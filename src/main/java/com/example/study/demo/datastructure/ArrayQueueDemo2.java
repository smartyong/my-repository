package com.example.study.demo.datastructure;

import java.util.Scanner;

/**
 * 将demo1中的队列优化为环形队列
 */
public class ArrayQueueDemo2 {

    public static void main(String[] args) {
        boolean isRun=true;
        ArrayQueue2 queue=new ArrayQueue2(4);
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
class ArrayQueue2 {
    private int maxSize;
    private int front;//前指针
    private int rear;//后指针
    private int[] arr;

    public ArrayQueue2(int maxSize){
        this.maxSize=maxSize;
        arr=new int[maxSize];
    }

    public boolean isFull(){
        return (rear+1)%maxSize==front;
    }
    public boolean isEmpty(){
        return front==rear;
    }

    public void add(int num){
        if (isFull()){
            System.out.println("队列已满，无法添加");
            return;
        }
        arr[rear]=num;
        //rear 后移
        rear=(rear+1)%maxSize;
    }
    public int get(){
        if (isEmpty()){
            throw new RuntimeException("队列为空 无法取数");
        }
        int value=arr[front];
        //front 后移
        front=(front+1)%maxSize;
        return value;
    }
    public void showQueue(){
        if (isEmpty()){
            System.out.println("队列为空");
        }
        for (int i = front; i <front+size() ; i++) {
            System.out.printf("%d \t",arr[i]);
        }
        System.out.println();
    }

    private int size(){
        return (rear+maxSize-front)%maxSize;
    }

    public int headNum(){
        if (isEmpty()){
            throw new RuntimeException("队列为空");
        }
        return arr[front];
    }
}



