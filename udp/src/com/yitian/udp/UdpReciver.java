package com.yitian.udp;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UdpReciver {
    public static void main(String[] args) throws IOException {
        DatagramSocket socket = new DatagramSocket(11111);
        //创建缓冲来接受和缓存远程发送的数据。
        byte[] array = new byte[1024];
        while (true){
        //创建一个数据包，用套接字口接受和存储远程发送来的数据包
        DatagramPacket packet = new DatagramPacket(array,array.length);
        //让当前
        socket.receive(packet);
        //得到数据
        byte[]  buff = packet.getData();
        //接受到的数据编码成字符串
        String str = new String(buff,"utf-8");
        String name = packet.getAddress().getHostName();
        System.out.println(name+":"+str);
        socket.close();
        }
    }
}
