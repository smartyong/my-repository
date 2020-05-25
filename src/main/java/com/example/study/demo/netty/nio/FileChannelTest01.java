package com.example.study.demo.netty.nio;

import java.io.*;
import java.nio.ByteBuffer;
import java.nio.channels.Channel;
import java.nio.channels.FileChannel;

/**
 * 往文件中写入字符串
 * Created by s94pcp on 2020/5/24.
 */
public class FileChannelTest01 {

    public static void main(String[] args)throws  Exception {

        System.out.println("start!!!");
        //创建 输出字符串
        String inputStr="hello,陌生人";
        //创建 输出 流
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\test1.txt");
        //生成 channel
        FileChannel fileChannel=fileOutputStream.getChannel();

        //创建 buffer
        ByteBuffer buffer=ByteBuffer.allocate(1024);
        //字符串写入buffer
        buffer.put(inputStr.getBytes());
        //读写转换  position 颠倒
        buffer.flip();
        //buffer 同步到channel
        fileChannel.write(buffer);
        //关闭资源
        fileOutputStream.close();
        fileChannel.close();
        System.out.println("close!!!!!");

    }

}
