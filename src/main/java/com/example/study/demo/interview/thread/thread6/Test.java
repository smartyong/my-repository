package com.example.study.demo.interview.thread.thread6;

/**
 *
 * java多线程轮流打印数字字母案例代码
 *
 * Created by Administrator on 2020/9/4 0004.
 */
public class Test {
    public static void main(String[] args) {
        Print print = new Print();
        new Thread(()->{
            print.printNum();
        }).start();

        new Thread(()->{
            print.printZimu();
        }).start();

        new Thread(()->{
            print.printZimuLittle();
        }).start();
    }
}
