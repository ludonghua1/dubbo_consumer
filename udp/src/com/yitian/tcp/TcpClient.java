package com.yitian.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.util.Scanner;

public class TcpClient {
    public static void main(String[] args) throws IOException {
        int port = 22222;
        Socket socket;
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入要对话的ip地址");
        String ip = scanner.nextLine();
        while (true){
            System.out.println("请输入会话：");
            String str = scanner.nextLine();
            socket = new Socket(ip, port);
            OutputStream out = socket.getOutputStream();
            out.write(str.getBytes("utf-8"));

            //读消息
            InputStream in = socket.getInputStream();
            byte[] buff = new byte[1024];
            in.read(buff);
            String message = new String(buff,"utf-8");
            System.out.println(ip+":"+message);

            out.flush();
            out.close();
            in.close();
            socket.close();
        }
    }
}
