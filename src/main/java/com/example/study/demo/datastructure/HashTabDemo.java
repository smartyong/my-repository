package com.example.study.demo.datastructure;


import java.util.Scanner;

public class HashTabDemo {

    public static void main(String[] args) {
        HashTab hashTab=new HashTab(7);

        while (true){
            System.out.println("=====选择操作=====");
            System.out.println("---add");
            System.out.println("---list");
            System.out.println("---exit");
            Scanner scanner=new Scanner(System.in);
            String op=scanner.nextLine();
            switch (op){
                case "add":
                    System.out.println("请输入id");
                    int id=new Scanner(System.in).nextInt();
                    System.out.println("请输入姓名");
                    String name=new Scanner(System.in).nextLine();
                    Emp emp=new Emp(id,name);
                    hashTab.addEmp(emp);
                    break;
                case "list":
                    hashTab.list();
                    break;
                case "exit":
                    System.exit(-1);
                    break;
            }

        }


    }

}

class HashTab{
    public LinkedEmpList[] empLinkedListArr;
    public int size;
    public HashTab(int size){
        empLinkedListArr=new LinkedEmpList[size];
        for (int i = 0; i < empLinkedListArr.length; i++) {
            empLinkedListArr[i]=new LinkedEmpList();
        }
        this.size=size;
    }

    public void addEmp(Emp emp){
        //获取链表下标
        int linkedListEmpIndex=hashFun(emp);
        empLinkedListArr[linkedListEmpIndex].add(emp);
    }

    public int hashFun(Emp emp){
        return emp.id%size;
    }

    public void list(){
        for (int i = 0; i < empLinkedListArr.length; i++) {
            empLinkedListArr[i].list(i);
        }
    }

}


class LinkedEmpList{
    public Emp head=new Emp(0,null);
    public int size;

    public void add(Emp emp){
        //找到链表尾部
        if (isEmpty()){
            head.next=emp;
            return;
        }
        Emp cur=head;
        while (true){
            if (cur.next==null){
                cur.next=emp;
                break;
            }else {
                //后移
                cur=cur.next;
            }
        }
    }
    public void list(int no){
        if (isEmpty()){
            System.out.println("第"+(no+1)+"链表为空！");
        }else{
            Emp cur=head;
            while (true){
                System.out.printf("第"+(no+1)+"链表为"+cur.toString());
                if (cur.next==null){
                    break;
                }else {
                    //后移
                    cur=cur.next;
                }
            }
            System.out.println();
        }
    }
    public boolean isFull(){
        return false;
    }
    public boolean isEmpty(){
        return head.next==null;
    }

}

class Emp{

    public int id;
    public String name;
    public Emp next;

    public Emp(int id,String name){
        this.id=id;
        this.name=name;
    }
    @Override
    public String toString() {
        return "Emp{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}

