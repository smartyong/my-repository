package com.example.study.demo.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

/**
 * Created by s94pcp on 2020/5/24.
 */
public class NioServer {

    public static void main(String[] args)throws Exception {
        Selector selector = Selector.open();
        ServerSocketChannel serverSocketChannel = ServerSocketChannel.open();
        InetSocketAddress inetSocketAddress=new InetSocketAddress(6666);
        serverSocketChannel.configureBlocking(false);
        serverSocketChannel.bind(inetSocketAddress);
        serverSocketChannel.register(selector,SelectionKey.OP_ACCEPT);
        while (true){
            int select = selector.select(1000);
            if (select==0){
                System.out.println("监听中......");
                continue;
            }else {
                System.out.println("监听到事件....");
                Set<SelectionKey> selectionKeys = selector.selectedKeys();
                Iterator<SelectionKey> keyIterator = selectionKeys.iterator();
                while (keyIterator.hasNext()){
                    SelectionKey selectionKey = keyIterator.next();
                    if (selectionKey.isAcceptable()){
                        SocketChannel socketChannel = serverSocketChannel.accept();
                        socketChannel.configureBlocking(false);
                        socketChannel.register(selector,SelectionKey.OP_READ,ByteBuffer.allocate(1024));
                    }
                    if (selectionKey.isReadable()){
                        SocketChannel channel = (SocketChannel)selectionKey.channel();
                        channel.configureBlocking(false);
                        ByteBuffer buffer=(ByteBuffer)selectionKey.attachment();
                        channel.read(buffer);
                        System.out.println("from client==="+new String(buffer.array()));
                    }
                    keyIterator.remove();//移除 防止重复连接
                }

            }

        }
        //关闭资源

    }
}
