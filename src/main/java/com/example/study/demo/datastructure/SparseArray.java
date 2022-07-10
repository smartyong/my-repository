package com.example.study.demo.datastructure;

import java.util.HashMap;

public class SparseArray {

    public static void main(String[] args) {
      int[] [] arr=new int[9][9];
      arr[1][1]=1;
      arr[2][3]=2;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                System.out.printf("%s  ",arr[i][j]);
            }
            System.out.println();
        }
      int valueCount=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){
                    valueCount++;
                }
            }
        }
      int[] [] sparseArr=new int[valueCount+1][3];
        sparseArr[0][0]=9;
        sparseArr[0][1]=9;
        sparseArr[0][2]=valueCount;
        int count=0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {
                if (arr[i][j]!=0){
                    count++;
                    sparseArr[count][0]=i;
                    sparseArr[count][1]=j;
                    sparseArr[count][2]=arr[i][j];
                }
            }
        }

        for (int i = 0; i <sparseArr.length ; i++) {
            for (int j = 0; j <sparseArr[i].length ; j++) {
                System.out.printf("%d \t",sparseArr[i][j]);
            }
            System.out.println();
        }
    }


}
