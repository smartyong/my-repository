package com.example.study.demo.datastructure.search;

/**
 * 插值法二分查找
 */
public class InsertValueSearch {

    public static void main(String[] args) {
        int[] arr={1,2,3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20};
        int findIndex=searchVal(arr,0,arr.length-1,3);
        System.out.println(findIndex);
    }
    public static int searchVal(int[] arr,int leftIndex,int rightIndex,int value){
        System.out.println("find");
        if (leftIndex>rightIndex){
            return -1;
        }
//        int middleIndex=(leftIndex+rightIndex)/2;
        int middleIndex=leftIndex+(rightIndex-leftIndex)*(value-arr[leftIndex])/(arr[rightIndex]-arr[leftIndex]);
        int middleValue=arr[middleIndex];
        if (value>middleValue){//向右递归
            return searchVal(arr,middleIndex+1,rightIndex,value);
        }else if (value<middleValue){//向左递归
            return searchVal(arr,leftIndex,middleIndex-1,value);
        }else {
            return middleIndex;
        }
    }
}
