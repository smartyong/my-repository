package com.example.study.demo.datastructure;

import java.util.Arrays;

public class HeapSortDemo {
    public static void main(String[] args) {
        int[] arr={4,6,8,5,9};
        heapSort(arr);
        System.out.println("堆排序后："+Arrays.toString(arr));
    }

    public static void   heapSort(int[] arrs) {
       int tmp =0;
       //调整为大顶堆
       for (int i=arrs.length/2-1;i>=0;i--){
           adjustHeap(arrs,i,arrs.length);
       }
        System.out.println("调整为大顶堆："+Arrays.toString(arrs));
       //交换头部和尾部元素 递归调整堆
        for (int j = arrs.length-1; j >0 ; j--) {
            tmp=arrs[j];
            arrs[j]=arrs[0];
            arrs[0]=tmp;
            adjustHeap(arrs,0,j);
        }

    }

    /**
     * 调整为大顶堆
     * @param arrs
     * @param index
     * @param length
     */
    public static void adjustHeap(int[] arrs, int index, int length) {
        // left =2*index+1
        // right=2*index+2
        int temp = arrs[index];//临时变量

        for (int k = 2 * index + 1; k < length; k = 2 * k + 1) {

            if (k + 1 < length && arrs[k] < arrs[k + 1]) {//左子节点小于右子节点
                k++;
            }
            if (temp<arrs[k]){
                //交换
                arrs[index]=arrs[k];
                index=k;
            }else {
                break;
            }
        }
        arrs[index]=temp;
    }

}
