package com.example.study.demo.interview.thread.thread4;

/**
 * Created by Administrator on 2020/9/3 0003.
 */
public class ContronlThread implements Runnable {
    private LettersSource lettersSource;

    public ContronlThread(LettersSource lettersSource){
        this.lettersSource=lettersSource;
    }

    @Override
    public void run() {
//        int i=0;
        while (true) {
            lettersSource.printLetters();
//            i++;
        }
    }
}
