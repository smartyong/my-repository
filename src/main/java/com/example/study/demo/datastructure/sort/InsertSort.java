package com.example.study.demo.datastructure.sort;

import java.util.Arrays;

/**
 * 插入排序
 */
public class InsertSort {
    public static void main(String[] args) {
        int[] arr={9,2,1,4,3,8};
        System.out.println("原始："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("结果："+Arrays.toString(arr));
    }

    public static void sort(int[] arr) {

        for (int i = 1; i <arr.length ; i++) {
            int insertValue = arr[i];
            int insertIndex = i - 1;
            while (insertIndex >= 0 && insertValue < arr[insertIndex]){
                arr[insertIndex+1]=arr[insertIndex];
                insertIndex--;
            }
            arr[insertIndex+1]=insertValue;
            System.out.println(Arrays.toString(arr));
        }
    }
}
