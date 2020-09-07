package com.example.study.demo.interview.thread.thread1;

import java.util.concurrent.TimeUnit;

/**
 * 资源类
 * Created by Administrator on 2020/9/3 0003.
 */
public class ProduceSource implements Runnable{

    private  int tikit;

    public int getTikit() {
        return tikit;
    }

    public void setTikit(int tikit) {
        this.tikit = tikit;
    }

    public ProduceSource(int tikit){
        this.tikit=tikit;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (this) {
                if (tikit > 0) {
                    tikit--;
                    System.out.println(Thread.currentThread() + "=剩余====" + tikit);
                    try {
                        TimeUnit.MILLISECONDS.sleep(100);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                } else {
                    break;
                }
            }
        }

    }
}
