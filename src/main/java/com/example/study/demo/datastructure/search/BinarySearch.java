package com.example.study.demo.datastructure.search;

import java.util.ArrayList;

/**
 * 二分查找算法（确保数组是有序的）
 */
public class BinarySearch {

    public static void main(String[] args) {

//        int[] arr={1,3,5,8,9,11};
//        int findIndex=searchVal(arr,0,arr.length-1,5);
//        System.out.println(findIndex);

        int[] arr={1,3,5,8,8,8,9,11};
        ArrayList res=searchVal2(arr,0,arr.length-1,8);
        System.out.println(res);
    }

    public static int searchVal(int[] arr,int leftIndex,int rightIndex,int value){
        if (leftIndex>rightIndex){
            return -1;
        }
        int middleIndex=(leftIndex+rightIndex)/2;
        int middleValue=arr[middleIndex];
        if (value>middleValue){//向右递归
            return searchVal(arr,middleIndex+1,rightIndex,value);
        }else if (value<middleValue){//向左递归
            return searchVal(arr,leftIndex,middleIndex-1,value);
        }else {
            return middleIndex;
        }
    }

    /**
     * 处理 查找数组中有多个相同的元素
     * @param arr
     * @param leftIndex
     * @param rightIndex
     * @param value
     * @return
     */
    public static ArrayList searchVal2(int[] arr, int leftIndex, int rightIndex, int value){
        if (leftIndex>rightIndex){
            return new ArrayList<Integer>();
        }
        int middleIndex=(leftIndex+rightIndex)/2;
        int middleValue=arr[middleIndex];
        if (value>middleValue){//向右递归
            return searchVal2(arr,middleIndex+1,rightIndex,value);
        }else if (value<middleValue){//向左递归
            return searchVal2(arr,leftIndex,middleIndex-1,value);
        }else {
            ArrayList<Integer> res=new ArrayList<>();
            //向左递归查找相同值
            int tmpIndex=middleIndex-1;
            while (true){
                if (tmpIndex<0||arr[tmpIndex]!=value){
                    break;
                }
                res.add(tmpIndex);
                tmpIndex=tmpIndex-1;
            }
            //向右递归查找相同值
            tmpIndex=middleIndex+1;
            while (true){
                if (tmpIndex>arr.length-1||arr[tmpIndex]!=value){
                    break;
                }
                res.add(tmpIndex);
                tmpIndex=tmpIndex+1;
            }
            return res;
        }
    }


}
