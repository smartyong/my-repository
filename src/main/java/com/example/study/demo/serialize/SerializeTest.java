package com.example.study.demo.serialize;

import java.io.*;
import java.util.Date;

/**
 * 序列化和反序列化 的 类必须实现 Serializable 接口
 * 并声明 private static final long serialVersionUID = 1L;
 *
 * Created by s94pcp on 2020/5/6.
 */
public class SerializeTest {

    public static void main(String[] args) throws IOException{
        //序列化
        MySerializeDTO mySerializeDTO=new MySerializeDTO();
        mySerializeDTO.setBirthDay(new Date());
        mySerializeDTO.setId(333333L);
        mySerializeDTO.setName("zhangsan");
        ObjectOutputStream outputStream=new ObjectOutputStream(new FileOutputStream("D://sererlise1.txt"));
        outputStream.writeObject(mySerializeDTO);
        outputStream.close();

        //反序列化
        ObjectInputStream inputStream=new ObjectInputStream(new FileInputStream("D://sererlise1.txt"));
        try {
            MySerializeDTO o = (MySerializeDTO) inputStream.readObject();
            System.out.println(o.toString());
            inputStream.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }


}
