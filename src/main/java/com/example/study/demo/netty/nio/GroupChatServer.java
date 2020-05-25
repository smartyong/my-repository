package com.example.study.demo.netty.nio;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.nio.ByteBuffer;
import java.nio.channels.*;
import java.util.Iterator;
import java.util.Set;

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
//                System.out.println("监听到客户端事件....");
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
                        //读取消息
                        readData(key);

                    }
                    //remove
                    keyIterator.remove();
                }

            }else {
                //没有事件
            }

        }

    }

    public  void readData(SelectionKey key)throws  Exception{
        try{
        SocketChannel channel = (SocketChannel)key.channel();
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        channel.read(buffer);
        String msg=new String(buffer.array());
        System.out.println("来自客户端消息："+msg);
        //往其他客户端推送消息
        sendMsgToOthers(msg,channel);
        }catch (Exception e){
            e.printStackTrace();
            SocketChannel channel = (SocketChannel)key.channel();
            try {
                System.out.println(channel.getRemoteAddress().toString().substring(1)+"已下线..");
            } catch (IOException e1) {
                e1.printStackTrace();
            }
            //取消注册
            key.cancel();
            channel.close();
        }
    }

    public  void  sendMsgToOthers(String msg,SocketChannel selfChannel) throws Exception{
        //selector.keys()  获取已经注册到selector 的所有 channel
        System.out.println("服务器转发消息中......");
        Set<SelectionKey> keys =  selector.keys();
        for (SelectionKey key:keys) {
            Channel channel = key.channel();//不能写成 SocketChannel dest=(SocketChannel)key.channel();
            if (channel instanceof SocketChannel &&channel!=selfChannel){
                //
                SocketChannel dest=(SocketChannel)channel;
//                ByteBuffer buffer=ByteBuffer.allocate(1024);
//                buffer.put(msg.getBytes());
                dest.write(ByteBuffer.wrap(msg.getBytes()));
                System.out.println("转发至："+dest.getRemoteAddress().toString().substring(1)+"完成！");
            }
        }

    }

    public static void main(String[] args) throws  Exception{
        GroupChatServer groupChatServer=new GroupChatServer();
        groupChatServer.lisen();
    }
}
