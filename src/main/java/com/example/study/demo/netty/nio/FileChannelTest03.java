package com.example.study.demo.netty.nio;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.nio.ByteBuffer;
import java.nio.channels.FileChannel;

/**
 * 同一个buffer 进行文件读写
 * Created by s94pcp on 2020/5/24.
 */
public class FileChannelTest03 {


    public static void main(String[] args)throws Exception {
        //读取文件

        //要读取的文件
        FileInputStream fileInputStream = new FileInputStream("D:\\test01.txt");
        //新建拷贝的文件
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\test02.txt");
        //对应的channel
        FileChannel fileInChannel = fileInputStream.getChannel();
        FileChannel fileOutChannel = fileOutputStream.getChannel();
        //buffer
        ByteBuffer buffer=ByteBuffer.allocate(10);

        while (true) {
            buffer.clear();//非常重要 不要忘了，否则 会造成死循环 read 一直是0
            //数据写入buffer
            int read = fileInChannel.read(buffer);
            if (read==-1){
                break;
            }
            //读写转换
            buffer.flip();

            //输出
            fileOutChannel.write(buffer);
        }

        //关闭资源
        fileInputStream.close();
        fileOutputStream.close();
        fileInChannel.close();
        fileOutChannel.close();
        System.out.println("end!");


    }


}
