package com.jzw.ch03_mvc.entity;

import org.springframework.web.multipart.MultipartFile;

public class UserFile {
    private String fileName;
    private MultipartFile multipartFile;

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    public MultipartFile getMultipartFile() {
        return multipartFile;
    }

    public void setMultipartFile(MultipartFile multipartFile) {
        this.multipartFile = multipartFile;
    }
}
