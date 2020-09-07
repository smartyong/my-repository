package com.example.study.demo.interview.thread.thread4;

/**
 * 面试笔试题  给定线程数 如 3个线程 依次打印 a-Z 字母包括大小写  打印2遍
 * Created by Administrator on 2020/9/3 0003.
 */
public class Test {
    public static void main(String[] args) {

        LettersSource lettersSource=new LettersSource();
        new Thread(new ContronlThread(lettersSource)).start();
        new Thread(new ContronlThread(lettersSource)).start();
        new Thread(new ContronlThread2(lettersSource)).start();
    }

}
