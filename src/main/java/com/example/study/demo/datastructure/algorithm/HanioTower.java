package com.example.study.demo.datastructure.algorithm;

/**
 * 汉诺塔问题  采用分治算法
 */
public class HanioTower {

    public static void main(String[] args) {

        hanioTower(5,'A','B','C');
    }

    /**
     * 步骤1 将 A柱最上一个盘 移到B柱
     * 步骤2 将 A柱最底一个盘 移到C柱
     * 步骤3 将 B柱最上一个盘 移到C柱
     *
     * @param num
     * @param a
     * @param b
     * @param c
     */
    public static void hanioTower(int num,char a,char b,char c){
        if (num==1){
            System.out.println(a+"==>"+c);
        }else {
            hanioTower(num-1,a,c,b);
            String ns=String.valueOf(num);
            System.out.println("数字"+ns+a+"===>"+c);
            hanioTower(num-1,b,a,c);
        }
    }

}
