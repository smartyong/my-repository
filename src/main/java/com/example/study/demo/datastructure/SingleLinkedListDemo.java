package com.example.study.demo.datastructure;

public class SingleLinkedListDemo {

    public static void main(String[] args) {

        SingleLinkedList list=new SingleLinkedList();

        HeroNode h1=new HeroNode(1,"宋江","及时雨");
        HeroNode h2=new HeroNode(2,"卢俊义","玉麒麟");
        HeroNode h3=new HeroNode(3,"吴用","智多星");
        HeroNode h4=new HeroNode(4,"林冲","豹子头");
//        list.addHero(h1);
//        list.addHero(h2);
//        list.addHero(h3);
//        list.addHero(h4);
        list.addHeroByOrder(h1);
        list.addHeroByOrder(h4);
        list.addHeroByOrder(h2);
        list.addHeroByOrder(h3);
        list.addHeroByOrder(h3);


        list.showHero();
    }

}

class SingleLinkedList{
    //先创建一个头部，不存储数据
    HeroNode head=new HeroNode(0,"","");
    public void addHero(HeroNode node){
        //找到链表末尾的节点
        HeroNode tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
        }
        tmp.next=node;
    }

    /**
     * 按排名顺序插入英雄 如果已存在排名 提示已存在
     * @param hero
     */
    public void addHeroByOrder(HeroNode hero){
        //遍历找到插入的位置
        HeroNode tmp=head;
        boolean isExist=false;
        while (tmp.next!=null){
            tmp=tmp.next;
            if(hero.no==tmp.no){
                isExist=true;
                break;
            }
            if (hero.no>tmp.no){
//                tmp=tmp.next;
                break;
            }
        }
        if (isExist){
            //已存在
            System.out.println("已存在排名，不能添加");
        }else {
            //添加
            hero.next=tmp.next;
            tmp.next=hero;
        }

    }

    public void showHero(){
        HeroNode tmp=head;
        while (tmp.next!=null){
            tmp=tmp.next;
            System.out.println(tmp.toString());
        }

    }


}

class HeroNode{
    public int no;
    private String name;
    private String nickname;
    public HeroNode next;

    public HeroNode(int no,String name,String nickname){
       this.no=no;
       this.name=name;
       this.nickname=nickname;
    }

    @Override
    public String toString() {
        return "HeroNode{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickname='" + nickname + '\'' +
                '}';
    }
}