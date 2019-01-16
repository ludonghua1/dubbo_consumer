package com.yitian.io;

import java.io.*;
import java.util.UUID;

public class Test{
    public static void main(String[] args) throws Exception {
        File file=new File("D://picture");
        Test c=new Test();
        c.copy1(file);
    }
    public void copy1(File file) throws Exception {
        File[] files=file.listFiles();
        if (files!=null) {
            for (File f : files) {
                if (f.isDirectory()){
                    copy1(f);
                }
                else {
                    if (f.getName().endsWith(".jpg")){
                        replace(f);
                    }
                }
            }
        }
    }
    public  void replace(File file) throws Exception {
        String  suffix=file.getName().substring(file.getName().lastIndexOf("."));
        //重新生成新文件名   dsfdsr3w43532435435szczvc.jpg
        String newName= UUID.randomUUID().toString()+suffix;
        FileInputStream in=new FileInputStream(file);
        FileOutputStream out=new FileOutputStream("e://1//"+newName);
        BufferedInputStream bin=new BufferedInputStream(in);
        BufferedOutputStream bout=new BufferedOutputStream(out);
        int temp;
        byte[] bytes=new byte[64];
        while ((temp=bin.read(bytes))!=-1){
            bout.write(bytes,0,temp);
        }
        bin.close();
        bout.flush();
        bout.close();
    }
}
