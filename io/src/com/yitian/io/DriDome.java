package com.yitian.io;

import java.io.File;

public class DriDome {
    public static int count;
    public void searchFile(File dir){
        if (dir.isDirectory()){
            File[] childen = dir.listFiles();
            if (childen!=null){
                for (File f:childen){
                    if(f.isDirectory()){
                        searchFile(f);
                    }else {
                        String name = f.getName();
                        if (name.endsWith("java")){
                            System.out.println(name);
                            count++;
                        }
                    }
                }
            }
        }
    }

    public static void main(String[] args) {
        File dir = new File("d://");
        DriDome driDome = new DriDome();
        driDome.searchFile(dir);
        System.out.println(count++);
    }

}
