package com.example.study.demo.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SocketChannel;

/**
 * Created by s94pcp on 2020/5/24.
 */
public class NioClient {

    public static void main(String[] args)throws  Exception {

        SocketChannel socketChannel=SocketChannel.open();

        InetSocketAddress inetSocketAddress=new InetSocketAddress("127.0.0.1",6666);

        socketChannel.connect(inetSocketAddress);

        socketChannel.configureBlocking(false);

        socketChannel.write(ByteBuffer.wrap("hello world".getBytes()));
        System.in.read();

    }
}
