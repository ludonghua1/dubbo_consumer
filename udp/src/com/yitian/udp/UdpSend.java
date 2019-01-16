package com.yitian.udp;


import java.io.IOException;
import java.net.*;
import java.util.Scanner;

public class UdpSend {
    public static void main(String[] args) throws IOException {
        //在本地开启一个udp socket
        DatagramSocket socket = new DatagramSocket();
        Scanner scanner = new Scanner(System.in);
        while (true){
            System.out.println("请输入会话：");
            String str = scanner.next();
            int port = 11111;
            //创建一个数据包，数据包需要数据和发送方
            SocketAddress address = new InetSocketAddress("192.168.1.100",port);
            DatagramPacket packet = new DatagramPacket(str.getBytes(),str.getBytes().length, address);
            socket.send(packet);
        }
    }
}
