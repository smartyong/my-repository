package com.example.study.demo.java8.lambda;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class Java8Test2 {

    public static void main(String[] args) {

        Vehicle1 myCar = new MyCar();
        myCar.print();
        MyWheel myWheel=new MyWheel();
        myWheel.print();

    }
}

interface  Vehicle1 {

    default  void print(){
        System.out.println("i am a car");
    }
    static  void  say(){
        System.out.println("Vehicle say");
    }
}

interface  FourWheel{

    default  void print(){
        System.out.println("i am a fourwheel car");
    }
}

class MyCar implements  Vehicle1,FourWheel{
    public void print() {
        Vehicle1.super.print();
        Vehicle1.say();
        System.out.println("MyCar");
    }

}
class  MyWheel implements FourWheel{

}
