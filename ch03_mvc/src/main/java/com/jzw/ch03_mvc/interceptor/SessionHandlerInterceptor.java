package com.jzw.ch03_mvc.interceptor;

import com.jzw.ch03_mvc.entity.User;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class SessionHandlerInterceptor implements HandlerInterceptor {
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response,Object handler) throws Exception{
        User user = (User)request.getSession().getAttribute("user");
        if(user == null){
            //如果没有登录 ，重定向到login.html
            response.sendRedirect("/login.html");
            return false;
        }
        return true;
    }

    //Controller方法执行完毕后，调用此方法
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView mav)
    throws Exception{

    }

    //页面渲染完毕后调用此方法
    //通常用来清除某些资源，类似java语法的finally
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response,Object handler,Exception ex)
    throws Exception{

    }
}
