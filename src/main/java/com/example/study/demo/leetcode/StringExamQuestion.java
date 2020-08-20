package com.example.study.demo.leetcode;

/**
 * Created by Administrator on 2020/8/15 0015.
 */
public class StringExamQuestion {


    public static void main(String[] args) {
        //longestPalindrome();
        longestCommonPrefix();

    }

    /**
     * 编写一个函数来查找字符串数组中的最长公共前缀。
     如果不存在公共前缀，返回空字符串 ""。

     * @return
     */
    private static String longestCommonPrefix() {
//        String[] strs=new String[]{"flower","flow","flight"};
//        String[] strs=new String[]{"dog","racecar","car"};
        String[] strs=new String[]{"aca","cba"};
        /*if (strs.length==0){
            return "";
        }
        int minLength=strs[0].length();
        for (int i = 1; i <strs.length ; i++) {
            if(strs[i].length()<minLength){
                minLength=strs[i].length();
            }
        }
        Integer maxCommonIndex=null;
        for (int i = 0; i <minLength ; i++) {
            char commonChar=strs[0].charAt(i);
            boolean isCommon=true;
            for (int j = 1; j <strs.length ; j++) {
                if (commonChar!=strs[j].charAt(i)){
                    isCommon=false;
                    break;
                }
            }
            if (!isCommon){
                break;
            }
            maxCommonIndex=i;

        }
        if (null==maxCommonIndex){
            System.out.println("\"\"");
            return "";
        }else {
        System.out.println(strs[0].substring(0,maxCommonIndex+1));
        return strs[0].substring(0,maxCommonIndex+1);
        }*/
        if(strs.length == 0){
            return "";
        }
        String str = strs[0];
        for(int i = 1; i < strs.length; i++){
            while(strs[i].indexOf(str) != 0){
                str=str.substring(0, str.length() - 1);
            }
        }
        System.out.println(str);
        return str;


    }

    /**
     * 最大回文子串    在leetcode 中报超时。。。
     * 测试用例   ccc  abad  ac  a
     * @return
     */
    private static String longestPalindrome() {
        String s="ccc";
        int maxLength=1;
        String result=s.length()==0?"":""+s.charAt(0);
        for (int i = 0; i <s.length() ; i++) {
            String  str=""+s.charAt(i);
            for (int j = i+1; j <s.length() ; j++) {
                str=str+s.charAt(j);
                String reverseStr= new StringBuffer().append(str).reverse().toString();
                if (str.equals(reverseStr)&&str.length()>maxLength){
                    result=str;
                    maxLength=str.length();
                }
            }
        }
        System.out.println(result);
        return  result;
    }


}
