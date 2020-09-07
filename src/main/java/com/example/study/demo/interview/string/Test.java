package com.example.study.demo.interview.string;

/**
 * 打印字母
 * Created by Administrator on 2020/9/4 0004.
 */
public class Test {

    public static void main(String[] args) {

        for (int i=0;i<26;i++){
            //打印26个大写字母
            System.out.print((char)(i+'A'));
        }
        System.out.println("==========");
        for (int i=0;i<26;i++){
            //打印26个小写字母
            System.out.print((char)(i+'a'));
        }
        System.out.println("==========");
        System.out.println('0'+'A');// 48+65 = 113 未指定类型--输出baiint
        System.out.println((char)('0'+'A'));// q 强转char --输出char
        System.out.println(10+'A'); //75 未指定类型--输出int
        System.out.println((char)10+'A'); //75 未指定类型--输出int
        System.out.println((char)(10+'A')); //K 强转char --输出char
        System.out.println((char)((char)10+'A')); //K 强转char --输出char
    }

}
