package com.example.study.demo.netty.nio;

import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;

/**
 * Created by s94pcp on 2020/5/25.
 */
public class GroupChatServer {

    private Selector selector;
    private ServerSocketChannel ssc;
    private static final int PORT = 8888;

    public GroupChatServer() throws Exception {
        selector = Selector.open();
        ssc = ServerSocketChannel.open();
        //绑定端口
        ssc.bind(new InetSocketAddress(PORT));
        //注册
        ssc.configureBlocking(false);
        ssc.register(selector, SelectionKey.OP_ACCEPT);

    }

    //监听 ServerSocketChannel ssc
    public void lisen()throws Exception {
        while (true) {
            int count = selector.select(1000);
            if (count>0){
                System.out.println("监听到客户端事件....");
                Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
                while (keyIterator.hasNext()){
                    SelectionKey key = keyIterator.next();
                    if (key.isAcceptable()){
                        SocketChannel channel = ssc.accept();
                        //注册
                        channel.configureBlocking(false);
                        channel.register(selector,SelectionKey.OP_READ);
                        //显示上线 离线？
                        System.out.println(channel.getRemoteAddress().toString().substring(1)+"已上线..");
                    }
                    if (key.isReadable()){
                        //往其他客户端推送消息
                        SocketChannel channel = (SocketChannel)key.channel();
                        sendMsgToOthers(channel);
                    }
                    //remove
                    keyIterator.remove();
                }

            }else {
                //没有事件
            }

        }

    }

    public  void  sendMsgToOthers(SocketChannel selfChannel) throws Exception{
        Iterator<SelectionKey> keyIterator = selector.selectedKeys().iterator();
        while (keyIterator.hasNext()){
            SelectionKey next = keyIterator.next();
            SocketChannel channel = (SocketChannel)next.channel();
            if (channel!=selfChannel){
                //
                ByteBuffer buffer=ByteBuffer.allocate(1024);
                selfChannel.read(buffer);
                buffer.flip();
                channel.write(buffer);
            }

        }

    }

    public static void main(String[] args) throws  Exception{
        GroupChatServer groupChatServer=new GroupChatServer();
        groupChatServer.lisen();
    }
}
