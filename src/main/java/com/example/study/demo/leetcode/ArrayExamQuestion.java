package com.example.study.demo.leetcode;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Administrator on 2020/8/21 0021.
 */
public class ArrayExamQuestion {

    public static void main(String[] args) {
        int[]  nums = new int[]{-1, 0, 1, 2, -1, -4};
        threeSum(nums);

    }

    /**
     * 三数之和
     * 给你一个包含 n 个整数的数组 nums，判断 nums 中是否存在三个元素 a，b，c ，使得 a + b + c = 0 ？请你找出所有满足条件且不重复的三元组。
     注意：答案中不可以包含重复的三元组。
     leecode 运行报超时。
     * @param nums
     * @return
     */
    public static List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> lists=new ArrayList<>();
        for (int i = 0; i <nums.length ; i++) {
            for (int j = i+1; j <nums.length ; j++) {
                for (int k = j+1; k <nums.length ; k++) {
                    if (nums[i]+nums[j]+nums[k]==0){
                        System.out.println(i+":"+j+":"+k);
                        System.out.println(nums[i]+":"+nums[j]+":"+nums[k]);
                        System.out.println("==============");
                        List<Integer> list=new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[j]);
                        list.add(nums[k]);
                        if (!lists.contains(list)){
                            System.out.println("===========add");
                            lists.add(list);
                        }
                    }
                }
            }
        }
        System.out.println(lists.size());
        return lists;
    }

}
