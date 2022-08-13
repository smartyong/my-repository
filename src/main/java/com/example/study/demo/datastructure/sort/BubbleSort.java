package com.example.study.demo.datastructure.sort;

import java.util.Arrays;

/**
 * 冒泡排序
 */
public class BubbleSort {

    public static void main(String[] args) {
        int[] arr={9,2,1,4,3,8};
        System.out.println("原始："+Arrays.toString(arr));
        sort(arr);
        System.out.println("结果："+Arrays.toString(arr));
    }

    public static void sort(int [] arr){

        for (int k = arr.length; k >0; k--) {
            boolean isChange=false;
            for (int i = 0; i < k; i++) {
                if (i+1< k&&arr[i]>arr[i+1]){
                    int tmp=arr[i];
                    arr[i]=arr[i+1];
                    arr[i+1]=tmp;
                }
            }
            System.out.println(Arrays.toString(arr));
        }
    }
}
