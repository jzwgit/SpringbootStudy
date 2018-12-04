package com.jzw.ch03_mvc.controller;


import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.web.servlet.error.AbstractErrorController;
import org.springframework.boot.autoconfigure.web.servlet.error.ErrorViewResolver;
import org.springframework.boot.web.servlet.error.DefaultErrorAttributes;
import org.springframework.boot.web.servlet.error.ErrorAttributes;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.fasterxml.jackson.databind.ObjectMapper;

public class ErrorController extends AbstractErrorController {
    Log log = LogFactory.getLog(ErrorController.class);
    public static final String ERROR_PATH = "/error";
    @Autowired
    ObjectMapper objectMapper;

    public ErrorController(ErrorAttributes errorAttributes) {
        super(errorAttributes);
    }

    public ErrorController(ErrorAttributes errorAttributes, List<ErrorViewResolver> errorViewResolvers) {
        super(errorAttributes, errorViewResolvers);
    }

    @RequestMapping(ERROR_PATH)
    public ModelAndView getErrorPath(HttpServletRequest request,HttpServletResponse response){
        Map<String, Object> model = Collections.unmodifiableMap(getErrorAttributes(request,false));

        //获取异常，有可能为空
        Throwable cause = getCause(request);
        int status = (Integer)model.get("status");

        //错误信息
        String message = (String)model.get("message");
        //友好提示
        String errorMessage = getErrorMessage(cause);
        //后台打印日志信息方便查错
        log.info(status+","+message,cause);
        response.setStatus(status);

        if(!isJsonRequest(request)){
            //error.btl模板显示错误的详细信息
            ModelAndView mav = new ModelAndView("/error.btl");
            mav.addAllObjects(model);
            mav.addObject("errorMessage",errorMessage);
            mav.addObject("status",status);
            mav.addObject("cause",cause);
            return mav;
        }else{
            Map error = new HashMap();
            error.put("success",false);
            error.put("errorMessage",errorMessage);
            error.put("message",message);
            writeJson(response,error);
            return null;
        }
    }

    protected Throwable getCause(HttpServletRequest request) {
        Throwable error = (Throwable)request.getAttribute("javax.servlet.error.exception");
        if (error != null) {
            while (error instanceof ServletException && error.getCause() != null) {
                error = ((ServletException) error).getCause();
            }
        }
        return error;
    }
    protected String getErrorMessage(Throwable ex) {
        /*不给前端显示详细错误*/
        return "服务器错误,请联系管理员";
    }
    protected boolean isJsonRequest(HttpServletRequest request){
        String requestUri =  request.getRequestURI();
        if(requestUri.endsWith(".json")){
            return true;
        }else{
            return (request.getHeader("accept").contains("application/json") || (request.getHeader("X-Requested-With") != null
                    && request.getHeader("X-Requested-With").contains("XMLHttpRequest")));
        }
    }
    protected void writeJson(HttpServletResponse response,Map error){
        response.setContentType("application/json;charset=utf-8");
        try {
            response.getWriter().write(objectMapper.writeValueAsString(error));
        } catch (IOException e) {
            // ignore
        }
    }

    @Override
    public String getErrorPath() {
        return null;
    }
}
