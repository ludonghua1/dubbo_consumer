package com.yitian.io;

import java.io.*;

public class IoDemo {
    public static void main(String[] args) throws IOException {
        File file = new File("D://1.txt");
        FileInputStream in = new FileInputStream(file);
        FileOutputStream out = new FileOutputStream("e:\\7.txt");
        int temp;
        while ((temp=in.read())!=-1){
            out.write(temp);
        }
        in.close();
        out.flush();
        out.close();
    }
}
