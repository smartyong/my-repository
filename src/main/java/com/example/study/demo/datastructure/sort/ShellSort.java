package com.example.study.demo.datastructure.sort;

import java.util.Arrays;

/**
 * 希尔排序
 */
public class ShellSort {
    public static void main(String[] args) {
        int [] arr={8,9,1,7,2,3,5,4,6,0};
        System.out.println("原始："+ Arrays.toString(arr));
        sort(arr);
        System.out.println("结果："+Arrays.toString(arr));
    }


    /**
     * 希尔排序--交换法
     * @param arr
     */
    public static void sort(int [] arr){

        for (int gap = arr.length/2; gap >=1 ; gap /=2) {
            //分成5组
            for (int i = gap; i <arr.length ; i++) {
                //遍历每组
                for (int j = i-gap; j >=0; j -=gap) {
                    if (arr[j]>arr[j+gap]){
                        //交换
                        int tmp=arr[j];
                        arr[j]=arr[j+gap];
                        arr[j+gap]=tmp;
                    }

                }
            }
        }
    }

    /**
     * 希尔排序--移位法
     * @param arr
     */
    public static void sort2(int [] arr){
        for (int gap = arr.length/2; gap>=1; gap /=2) {

            for (int i = gap; i <arr.length ; i++) {
                int tmp=arr[i];
                int j=i;
                while (j>=0&&tmp<arr[j]){
                    //后移
                    arr[j+gap]=arr[j];
                    j-=gap;
                }
                arr[j+gap]=tmp;
            }
        }

    }

}
