package com.example.study.demo.netty.nio;

import java.nio.Buffer;
import java.nio.IntBuffer;

/**
 * Created by s94pcp on 2020/5/24.
 */
public class BufferBaseTest {

    public static void main(String[] args) {
        //新建int buffer 大小为10
        IntBuffer intBuffer=IntBuffer.allocate(10);
        //写入数据
        for (int i = 0; i <intBuffer.capacity() ; i++) {
            intBuffer.put(i*2);
        }
        //读写转换
        intBuffer.flip();
        //读取数据
        while (intBuffer.hasRemaining()){
            System.out.println(intBuffer.get());
        }

    }

}
