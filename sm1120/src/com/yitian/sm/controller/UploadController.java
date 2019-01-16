package com.yitian.sm.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import javax.servlet.http.HttpServletRequest;
import java.io.*;



@Controller
public class UploadController {
    @RequestMapping("/toupload.action")
    public String toupload(HttpServletRequest request){
        return "upload";
    }



    @RequestMapping("/upload.action")
    //@RequestParam
    //将GET和POST请求传的参数会自动转换赋值到@RequestParam 所注解的变量上
    public void toupload(@RequestParam("file") MultipartFile file) throws IOException {
        //获取输入流
        InputStream in = file.getInputStream();
        //获取输出流                                                  获取原文件名
        OutputStream out = new FileOutputStream("D:\\picture\\"+file.getOriginalFilename());
        //
        int temp;
        while ((temp=in.read())!=-1){
            out.write(temp);
        }
        out.flush();
        in.close();
        out.close();
        System.out.println("上传成功！");
    }
}
