package com.yitian.tcp;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;

public class TcoSocketServer {
    public static void main(String[] args) throws IOException {
        int port = 22222;
        //创建一个tcp的socketfuwuduan，监听指定端口号，开启三次握手
        ServerSocket serverSocket = new ServerSocket(port);
        Socket socket;
        Scanner scanner = new Scanner(System.in);

        while (true){
        //当有tcp的连接通过端口号进入的时候，该方法就会获取socketlianjie
            socket = serverSocket.accept();
            //获取到该连接的输入流对象
            InputStream in = socket.getInputStream();
            //读取到数据缓冲区
            byte[] array = new byte[1024];
            in.read(array);
            String message = new String(array,"utf-8");
            String customer = socket.getInetAddress().getHostAddress();
            System.out.println(customer+":"+message);

            //读完消息，写消息
            System.out.println("回复：");
            String str = scanner.nextLine();
            //获取输出流，将回复写回socket
            OutputStream out = socket.getOutputStream();
            out.write(str.getBytes("utf-8"));
            //关闭资源
            in.close();
            out.flush();
            out.close();
            socket.close();
        }

    }
}
