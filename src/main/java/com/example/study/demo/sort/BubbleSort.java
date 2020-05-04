package com.example.study.demo.sort;

/**
 *冒泡排序（假如从小到大排序）
 第一遍
 第一个元素和第二个元素比较大小，如果第一个元素比第二个大，则交换值，
 然后第二个元素再和第三个元素比较大小，如果第二个元素比第三个大，则交换值，。。。以此类推 和第N个元素比较， 最大值找到 放在末尾N处
 第二遍
 第一个元素和第二个元素比较大小，如果第一个元素比第二个大，则交换值，
 然后第二个元素再和第三个元素比较大小，如果第二个元素比第三个大，则交换值，。。。以此类推 和第N-1个元素比较 最大值找到 放在N-1处
 * Created by s94pcp on 2020/5/4.
 */
public class BubbleSort {

    public static void main(String[] args) {

        int [] numbs={1,3,6,4,7,2,5,8};
        for (int j=numbs.length;j>0;j--) {
            for (int i = 0; i+1 <j; i++) {
                int temp=0;
                if (numbs[i]>numbs[i+1]) {
                    temp=numbs[i];
                    numbs[i]=numbs[i+1];
                    numbs[i+1]=temp;
                }
            }
        }
        for (int i : numbs) {
            System.out.println(i);
        }
    }
}
