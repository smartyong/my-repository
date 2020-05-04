package com.example.study.demo.sort;

/**
 *
 * *插入排序（假設從小到大排序）將元素從前2個開始排序，後面的元素加入到前面去排序，插入
 * 第一遍
 * 第一個元素和第二個元素比較，如果第一個大於第二個，則互換，
 * 第二遍
 * 第三個元素 依次和第一個，第二個 元素比較，如大於，則互換。
 * 。
 * 。
 * 。
 * 以此類推  最終排序完成
 * Created by s94pcp on 2020/5/4.
 */
public class InsertSort {

    public static void main(String[] args) {
        int numbs[]={3,2,1,4,7,6,5,8};
        for (int i = 1; i < numbs.length; i++) {
            int temp=numbs[i];
            int leftIndx;
            for (leftIndx=i-1; leftIndx>=0; leftIndx--) {
                if (numbs[leftIndx]>temp) {
                    numbs[leftIndx+1]=numbs[leftIndx];
                }else {
                    break;
                }
            }
            numbs[leftIndx+1]=temp;
            for (int a : numbs) {
                System.out.print("|"+a);
            }
            System.out.println("====第"+i+"次====");
        }

    }
}
