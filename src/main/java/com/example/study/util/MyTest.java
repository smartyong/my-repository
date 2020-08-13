package com.example.study.util;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Administrator on 2020/7/14 0014.
 */
public class MyTest {

    public static void main(String[] args) {
       /* int [] arrays={2,4,5,7,6};
        int target=9;
        int [] result=new int[2];
        for (int i = 0; i < arrays.length; i++) {
            for (int j = i+1; j <arrays.length ; j++) {
                int sum=arrays[i]+arrays[j];
                if (sum==target){
                    System.out.println(i+","+j);
                    result[0]=i;
                    result[1]=j;
                }
            }
        }*/
       String a="abc123efg";
       String b="fuab1efg";

        List<String> strings=new ArrayList<>();
        String s="";
        for (int i = 0; i <a.length() ; i++) {
            char ac=a.charAt(i);
            boolean isSame=false;
            for (int j = 0; j < b.length(); j++) {
                char bc=b.charAt(j);
                if (ac==bc){
                    isSame=true;
                    break;
                }
            }
            if(isSame){
                s=s+ac;
            }else {
                if (s.length()>0){
                    strings.add(s);
                    s="";
                }
            }
        }

        if (!strings.isEmpty()){
            int maxlenth=0;
            int maxlenthindx=0;
            for (int k=0; k<strings.size();k++) {
                if(strings.get(k).length()>maxlenth){
                    maxlenth=strings.get(k).length();
                    maxlenthindx=k;
                    System.out.println(strings.get(k));
                }
            }
            System.out.println("max===="+strings.get(maxlenthindx));
        }





    }

}
