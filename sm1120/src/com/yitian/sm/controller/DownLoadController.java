package com.yitian.sm.controller;


import org.apache.commons.io.FileUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.OutputStream;

@Controller
public class DownLoadController {
    public static final String PICTURE_PATH="D:\\picture";
    @RequestMapping("/todownload.action")
    public String todownload(HttpServletRequest request){
        File file = new File(PICTURE_PATH);
        File[] children = file.listFiles();
        request.setAttribute("files",children);
        return "fileList";
    }
    /*
    * 下载资源（写法1：使用原生的servlet的功能）
    * */
    @RequestMapping("/download.action")
    public void download(String filename, HttpServletResponse response) throws IOException {
        //真实物理位置
        String realPath =PICTURE_PATH+"\\"+filename;
        //得到文件路径
        File file  = new File(realPath);
        //得到文件的输入流
        FileInputStream in = new FileInputStream(file);
        //输出流
        OutputStream out = response.getOutputStream();
        //由于response默认响应的是html格式的字符串，需要设置响应头信息，告诉浏览器，响应的是一个附件
        response.setContentType("appliction/x-msdownload");
        //告诉浏览器以附件形式下载
        response.setHeader("Content-disposition", "attachment; filename=" + new String(filename.getBytes("utf-8"), "ISO8859-1"));
        //告诉浏览器文件的长度
        response.setHeader("Content-Length", String.valueOf(file.length()));
        byte[] buffer = new byte[1024];
        int len;
        while ((len=in.read(buffer))!=-1){
            out.write(buffer,0,len);
        }
        out.flush();
        in.close();
        out.close();
    }
    @RequestMapping("/download1.action")
    public ResponseEntity<byte[]> download1(String filename, HttpServletResponse response) throws IOException {
        HttpHeaders headers = new HttpHeaders();
        File file = new File(PICTURE_PATH+"\\"+filename);
        headers.setContentType(MediaType.APPLICATION_OCTET_STREAM);
        headers.setContentDispositionFormData("attachment",filename);
        headers.setContentLength(file.length());
        return new ResponseEntity<byte[]>(FileUtils.readFileToByteArray(file),headers, HttpStatus.CREATED);
    }

}
