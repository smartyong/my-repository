package com.example.study.demo.datastructure;

import java.util.Scanner;

public class ArrayQueueDemo {

    public static void main(String[] args) {
        boolean isRun=true;
        ArrayQueue2 queue=new ArrayQueue2(3);
        char op;
        while (isRun){
            System.out.println("===操作菜单===");
            System.out.println("a--->添加数据");
            System.out.println("g--->获取数据");
            System.out.println("h--->头部数据");
            System.out.println("s--->遍历队列");
            System.out.println("e--->退出--");
            Scanner scanner=new Scanner(System.in);
            op = scanner.nextLine().charAt(0);
            switch (op){
                case 'a':
                    System.out.println("输入数字");
                    int n=new Scanner(System.in).nextInt();
                    queue.add(n);
                    break;
                case 'g':
                    try {
                        int b = queue.get();
                        System.out.println("取出:"+b);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 's':
                    queue.showQueue();
                    break;
                case 'h':
                    try {
                        int c = queue.headNum();
                        System.out.println("头部数据:"+c);
                    } catch (Exception e) {
                        System.out.println(e.getMessage());
                    }
                    break;
                case 'e':
                    System.out.println("退出！");
                    isRun=false;
                    break;
            }

        }






    }

}
class ArrayQueue{
    private int maxSize;
    private int front=-1;//前指针
    private int rear=-1;//后指针
    private int[] arr;

    public ArrayQueue(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return rear==maxSize-1;
    }
    public boolean isEmpty(){
        return front==rear;
    }
    public void add(int num){
        if (isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        rear++;
        arr[rear]=num;
    }
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空 无法取数");
        }
        front++;
        return arr[front];
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = 0; i <arr.length ; i++) {
            System.out.printf("%d \t",arr[i]);
        }
        System.out.println();
    }

    public int headNum(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front+1];
    }
}



