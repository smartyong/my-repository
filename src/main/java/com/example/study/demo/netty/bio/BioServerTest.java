package com.example.study.demo.netty.bio;

import java.io.IOException;
import java.io.InputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * Created by s94pcp on 2020/5/24.
 */
public class BioServerTest {

    public static void main(String[] args) {
        //新建线程池
        ExecutorService cachedThreadPool = Executors.newCachedThreadPool();
        //新建Server Socket
        try (ServerSocket serverSocket = new ServerSocket(6666)) {
            System.out.println("服务器端启动了！");
            while (true) {
                System.out.println("等待客户端连接..........");
                Socket socket = serverSocket.accept();
                System.out.println("一个客户端连接进来了！");
                cachedThreadPool.execute(() -> {
                    //handel
                    System.out.println("当前线程信息："+Thread.currentThread().getName()+"---"+Thread.currentThread().getId());
                    handel(socket);
                });
            }

        } catch (Exception e) {
            e.printStackTrace();
        } finally {

        }
    }

    public static void handel(Socket socket) {

        try {

            InputStream inputStream = socket.getInputStream();
            byte[] bytes = new byte[1024];
            while (true) {
                System.out.println("等待客户端输入.............");
                int read = inputStream.read(bytes);
                if (read != -1) {
                    //打印 输出
                    System.out.println(new String(bytes, 0, read));
                } else {
                    break;
                }

            }

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                socket.close();
                System.out.println("关闭socket 连接！");
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

}
