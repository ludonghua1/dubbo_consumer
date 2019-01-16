package com.yitian.io;

import java.io.*;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

public class Io {
    public static void main(String[] args) throws IOException {
        //创建带缓冲的输入流对象
        BufferedReader br=new BufferedReader(new FileReader("d://1.txt"));
        //创建输出流对象
        BufferedWriter bw=new BufferedWriter(new FileWriter("e:\\4.txt"));
        //创建集合对象Map
        HashMap<Integer,Integer> tm=new HashMap<Integer, Integer>();
        //将读到的字符存储在Map集合中,存储的时候要做判断,如果包含这个键,就将该键和值加1存储,如果不包含这个键,就将键和1存储,
        int ch;
        //次数
        Integer count;
        while ((ch=br.read())!=-1){
            if(tm.containsKey(ch)){
                count=tm.get(ch);
                count++;
                tm.put(ch,count);
            }else {
                tm.put(ch,1);
            }
        }
        //关闭输入流
        br.close();
        //Set集合
        Set set=tm.keySet();
        //使用迭代器遍历
        Iterator it=set.iterator();
        while (it.hasNext()){
            int k= (int) it.next();
            String v=tm.get(k)+"";
            bw.write(k);
            bw.write("********");
            bw.write(v);
            bw.newLine();
            System.out.println(k+"********"+v);
        }
        //刷新
        bw.flush();
        //关闭输出流
        bw.close();
    }

}
