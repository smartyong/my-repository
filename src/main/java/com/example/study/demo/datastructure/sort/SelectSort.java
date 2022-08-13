package com.example.study.demo.datastructure.sort;

import java.util.Arrays;

/**
 * 选择排序
 */
public class SelectSort {

    public static void main(String[] args) {
        int[] arr={9,2,1,4,3,8};
        System.out.println("原始："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("结果："+Arrays.toString(arr));
    }

    public static void sort(int [] arr){

        for (int i = 0; i <arr.length ; i++) {
            for (int j = i; j+1 <arr.length ; j++) {
                if (arr[i]>arr[j+1]){
                    int tmp=arr[i];
                    arr[i]=arr[j+1];
                    arr[j+1]=tmp;
                }
            }
        }

    }

}
