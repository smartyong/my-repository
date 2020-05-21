package com.example.study.demo.juc.volatile_info.atomic;

import java.util.*;
import java.util.concurrent.CopyOnWriteArrayList;
import java.util.concurrent.TimeUnit;

/**
 * Created by s94pcp on 2020/5/21.
 */
public class ArrayListTest {

    public static void main(String[] args) {
//        nonAtomicTest();  线程不同步
//        Vector<Integer>  nums= new Vector<>();线程同步
//        List<Integer> nums=Collections.synchronizedList(new ArrayList<>());线程同步
        CopyOnWriteArrayList<Integer> nums= new CopyOnWriteArrayList<>();

            new Thread(()->{
                for (int j = 0; j <1000 ; j++) {
                    nums.add(j);
                }
            },"AAA").start();
            new Thread(()->{
            for (int j = 1000; j <2000; j++) {
                nums.add(j);
            }
        },"BBB").start();

//        System.out.println(nums.size());
        for (int i = 0; i <nums.size() ; i++) {
            System.out.println("第"+i+"个==="+nums.get(i));
        }
        System.out.println(nums.size());
    }

    private static void nonAtomicTest() {
        List<Integer> nums=new ArrayList<>();
        for (int i = 1; i <=10 ; i++) {
            new Thread(()->{
                for (int j = 0; j <100 ; j++) {
                    nums.add(j);
                }
            },String.valueOf(i)).start();

        }
        for (int i = 0; i <nums.size() ; i++) {
            System.out.println("第"+i+"个==="+nums.get(i));
        }
        System.out.println(nums.size());
    }

}
