package com.面试相关.TCP;

import java.io.*;
import java.net.*;

public class TCPServer {
    public static void main(String[] args) {
        try (ServerSocket serverSocket=new ServerSocket(8080)){
            System.out.println("server is Listening on port 8080");
            while (true){
                Socket socket=serverSocket.accept();
                new ServerThread(socket).start();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}

class ServerThread extends Thread {
    private Socket socket;

    public ServerThread(Socket socket) {
        this.socket = socket;
    }

    public void run() {
        try (PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            // 读取客户端消息
            String message = in.readLine();
            System.out.println("Received: " + message);

            // 响应客户端
            out.println("Hello, client!");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
