package com.example.study.demo.juc;

import lombok.ToString;

import java.util.concurrent.Delayed;
import java.util.concurrent.TimeUnit;

/**
 * Created by s94pcp on 2020/5/15.
 */
@ToString
public class Item implements Delayed{

    private long time;
    String name;

    public  Item(long time,String name,TimeUnit unit){
        this.time=System.currentTimeMillis() + (time > 0? unit.toMillis(time): 0);
        this.name=name;
    }

    @Override
    public long getDelay(TimeUnit unit) {
        return time-System.currentTimeMillis();
    }

    @Override
    public int compareTo(Delayed o) {
        Item i=(Item)o;
        if (this.time-i.getTime()<=0){
            return -1;
        }else {
            return 1;
        }
//        return 0;
    }

    public long getTime() {
        return time;
    }

    public void setTime(long time) {
        this.time = time;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
