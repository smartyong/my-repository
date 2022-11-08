package com.example.study.demo.leetcode;

import java.util.HashMap;
import java.util.Stack;

public class StackTest {

    public static void main(String[] args) {
        System.out.println(isValid("()"));
    }
    public static boolean isValid(String s) {
        int length=s.length();
        if(length%2!=0){
            return false;
        }
        HashMap<Character,Character> map=new HashMap();
        map.put(')','(');
        map.put(']','[');
        map.put('}','{');
        Stack sta=new Stack();
        for(int i=0;i<length;i++){
            char c=s.charAt(i);
            if(map.containsKey(c)){
                if(sta.isEmpty()||map.get(c)!=sta.peek()){
                    return false;
                }
                sta.pop();
            }else{
                sta.push(c);
            }
        }
        return sta.isEmpty();
    }

}
