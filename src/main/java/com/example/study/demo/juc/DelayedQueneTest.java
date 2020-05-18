package com.example.study.demo.juc;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.concurrent.DelayQueue;
import java.util.concurrent.TimeUnit;

/**
 * Created by s94pcp on 2020/5/15.
 */
public class DelayedQueneTest {

    public static void main(String[] args) {
        DelayQueue<Item> delayQueue=new DelayQueue<>();
        delayQueue.put(new Item(10,"a", TimeUnit.SECONDS));
        delayQueue.put(new Item(15,"b", TimeUnit.SECONDS));
        delayQueue.put(new Item(20,"c", TimeUnit.SECONDS));
        for (int i = 0; i <3 ; i++) {
            try {
                Item item=delayQueue.take();
                System.out.println(item.toString()+ LocalDateTime.now().format(DateTimeFormatter.ISO_DATE_TIME));
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }


}
