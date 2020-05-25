package com.example.study.demo.netty.nio;

import java.io.FileInputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 从文件中读取字符串
 * Created by s94pcp on 2020/5/24.
 */
public class FileChannelTest02 {

    public static void main(String[] args)throws Exception {
        System.out.println("start!!");
        //输入流
        FileInputStream fileInputStream=new FileInputStream("D:\\test1.txt");
        // 得到对应的 channel
        FileChannel channel = fileInputStream.getChannel();
        //buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);// file.length 比较合理
        // chanel 中数据读取到 buffer 中
        channel.read(buffer);
        //打印
        System.out.println(new String(buffer.array()));
        //关闭资源
        fileInputStream.close();
        channel.close();
        System.out.println("end!!!");
    }

}
