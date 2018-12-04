package com.jzw.ch03_mvc.controller;

import org.springframework.format.datetime.DateFormatter;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.io.InputStream;

/**
 * MultipartFile
 * getOriginalFilename（）,获取上传的文件名字
 * getBytes(),获取上传文件内容，转为字节数组
 * getInputStream(),获取一个InputStream
 * isEmpty(),判断文件是否为空
 * getSize(),上传文件的大小
 * transferTo(File dest)，保存上传文件到目标文件系统
 */

@Controller
@RequestMapping("/file")
public class FileController {
    @PostMapping("/form")
    @ResponseBody
    public String handleFormUpload(String name, MultipartFile file) throws IOException {
        if(!file.isEmpty()){
            String fileName = file.getOriginalFilename();
            InputStream is = file.getInputStream();
            //处理上传内容
            File file1 = new File("D:/fileTest");
            file.transferTo(file1);

            return "success";
        }
        return "error";
    }

    /**
     * 处理多文件上传
     * @param name
     * @param files MultipartFile[]
     * @return
     * @throws IOException 线程异常
     */
    @PostMapping("/form2")
    @ResponseBody
    public String handleFormUpload2(String name,MultipartFile[] files)throws IOException{

        return "";
    }

    //自定义扩展绑定的特性
    @InitBinder
    protected void initBinder(WebDataBinder binder){
        binder.addCustomFormatter(new DateFormatter("yyyy-MM-dd"));
    }


}
