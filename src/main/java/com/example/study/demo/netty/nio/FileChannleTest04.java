package com.example.study.demo.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.channels.FileChannel;

/**
 * 使用 transferFrom 快速复制
 * Created by s94pcp on 2020/5/24.
 */
public class FileChannleTest04 {

    public static void main(String[] args) throws  Exception{

        FileInputStream fileInputStream=new FileInputStream("D:\\1.PNG");
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\2.PNG");

        FileChannel inChannel = fileInputStream.getChannel();
        FileChannel outChannel = fileOutputStream.getChannel();

        //复制
        outChannel.transferFrom(inChannel,0,inChannel.size());

        //关闭资源
        inChannel.close();
        outChannel.close();
        fileInputStream.close();
        fileOutputStream.close();


    }


}
