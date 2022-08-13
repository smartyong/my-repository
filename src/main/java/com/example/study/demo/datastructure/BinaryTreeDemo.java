package com.example.study.demo.datastructure;

public class BinaryTreeDemo {

    public static void main(String[] args) {
        HerooNode h1=new HerooNode(1,"宋江");
        HerooNode h2=new HerooNode(2,"卢俊义");
        HerooNode h3=new HerooNode(3,"吴用");
        HerooNode h4=new HerooNode(4,"公孙胜");
        HerooNode h5=new HerooNode(5,"关胜");
        HerooNode h6=new HerooNode(6,"林冲");
        h1.left=h2;
        h1.right=h3;
        h2.left=h4;
        h2.right=h5;
        h3.left=h6;
        h1.preOrder();
        System.out.println(h1.preSeach(8)==null?"未找到！":h1.preSeach(8).toString());

    }

}

class HerooNode{
    public int no;
    public String name;
    public HerooNode left;
    public HerooNode right;

    public HerooNode(int no,String name){
        this.no=no;
        this.name=name;
    }

    /**
     * 前序查找
     * @param no
     * @return
     */
    public HerooNode preSeach(int no){
        if (this.no==no){
            return this;
        }
        HerooNode re=null;
        if (this.left!=null){
            re=this.left.preSeach(no);
        }
        if (re!=null){
            return re;
        }
        if (this.right!=null){
            re=this.right.preSeach(no);
        }
        return re;
    }

    /**
     * 前序遍历
     */
    public void  preOrder(){
        if (this==null){
            System.out.println("为空不能遍历");
            return;
        }
        System.out.println(this.toString());
        if (this.left!=null){
            this.left.preOrder();
        }
        if (this.right!=null){
            this.right.preOrder();
        }
    }

    @Override
    public String toString() {
        return "HerooNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                '}';
    }
}