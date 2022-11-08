package com.example.study.demo.datastructure.algorithm;

public class VoilentMatch {

    public static void main(String[] args) {
       String s1="好你好啊啊你好好你";
       String s2="你好啊";
        int i = voilentMatch(s1, s2);
        System.out.println(i);
    }

    /**
     * 暴力匹配 查找字符串
     * @param s1
     * @param s2
     * @return
     */
    public static int voilentMatch(String s1 , String s2){
        char[] a1 = s1.toCharArray();
        char[] a2 = s2.toCharArray();

        int i=0;
        int j=0;
        while (i<a1.length&&j<a2.length){
            if (a1[i]==a2[j]){
                i++;
                j++;
            }else {
                i=i-(j-1);
                j=0;
            }
        }
        if (j==a2.length){
            return i-j;
        }else {
            return -1;
        }
    }
}
