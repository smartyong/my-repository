package com.example.study.demo.juc.volatile_info;

/**
 * Created by s94pcp on 2020/5/16.
 */
public class SingetonDemoTest {

    private static volatile SingetonDemoTest instance=null;

    private SingetonDemoTest(){
        System.out.println(Thread.currentThread().getName()+"  :SingetonDemoTest constuctor invoke");
    }

    public static   SingetonDemoTest  getInstance(){
        if (instance == null) {
            synchronized (SingetonDemoTest.class){
                if (instance == null) {
                    instance=new SingetonDemoTest();
                }
            }
        }
        return  instance;
    }


    public static void main(String[] args) {

//        System.out.println(SingetonDemoTest.getInstance()==SingetonDemoTest.getInstance());
//        System.out.println(SingetonDemoTest.getInstance()==SingetonDemoTest.getInstance());
//        System.out.println(SingetonDemoTest.getInstance()==SingetonDemoTest.getInstance());

        for (int i = 0; i <10 ; i++) {
            new Thread(()->{
                SingetonDemoTest instance = SingetonDemoTest.getInstance();
            },String.valueOf(i)).start();
        }

    }
}
