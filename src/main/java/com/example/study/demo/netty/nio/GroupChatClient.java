package com.example.study.demo.netty.nio;

import java.net.Inet4Address;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.SelectableChannel;
import java.nio.channels.SelectionKey;
import java.nio.channels.Selector;
import java.nio.channels.SocketChannel;
import java.util.Iterator;
import java.util.Scanner;
import java.util.concurrent.TimeUnit;

/**
 * 发送消息，接收消息
 * Created by s94pcp on 2020/5/25.
 */
public class GroupChatClient {
    private Selector selector;
    private SocketChannel socketChannel;
    private static final String HOST = "127.0.0.1";
    private static final int PORT = 8888;
    private String name;

    public GroupChatClient() throws Exception {
        selector = Selector.open();
        socketChannel = SocketChannel.open(new InetSocketAddress(HOST, PORT));
        socketChannel.configureBlocking(false);
        //注册到 selector
        socketChannel.register(selector, SelectionKey.OP_READ);
        name = socketChannel.getLocalAddress().toString().substring(1);
    }

    //发送消息
    public void sendMsg(String msg) throws Exception {
        msg = name + "说:" + msg;
        socketChannel.write(ByteBuffer.wrap(msg.getBytes()));
    }

    //读取消息
    public void readMsg(){
        try {
            int count = selector.select(1000);
            if (count > 0) {
                System.out.println("count is:" + count);
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()) {
                    SelectionKey key = keyIterator.next();
                    if (key.isReadable()) {
                        System.out.println("开始读取信息........");
                        SocketChannel channel = (SocketChannel) key.channel();
                        ByteBuffer buffer = ByteBuffer.allocate(1024);
                        //读取到buffer
                        channel.read(buffer);
                        //打印
                        System.out.println(new String(buffer.array()).trim());
                    }
                    keyIterator.remove();
                }
            } else {

            }
        }catch (Exception e){
            e.printStackTrace();
        }
    }

    public static void main(String[] args) throws Exception {
        GroupChatClient groupChatClient = new GroupChatClient();
        new Thread(
                () -> {
                    //读取数据
                    while (true) {
                        groupChatClient.readMsg();
                        try {
                            TimeUnit.SECONDS.sleep(3);
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }
                }
        ).start();

        Scanner scanner = new Scanner(System.in);

        while (scanner.hasNextLine()) {
            String msg = scanner.nextLine();
            groupChatClient.sendMsg(msg);

        }

    }

}
