package com.example.study.demo.java8.lambda;

import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.stream.Collectors;

import static java.util.Comparator.comparingInt;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class LambdaTest {

    public static void main(String[] args) {
        List<String> ls=new ArrayList<>();
        ls.add("bb");
        ls.add("aaa");
        ls.add("c");
        System.out.println(ls.toString());
//        Collections.sort(ls, comparingInt(String::length));
        ls.sort(comparingInt(String::length));
        System.out.println(ls.toString());
        ls.forEach(System.out::println);
        System.out.println("=========================================");
        MyInterface mi =new MyInterface() {
            @Override
            public void say(String s) {
                System.out.println(s);
            }
        };
        mi.say("helloworld");

        MyInterface mi2=  x -> System.out.println(x);
        mi2.say("helloworld2");
        System.out.println("=========================================");
        Random random=new Random();
        random.ints().limit(10).sorted().forEach(System.out::println);
        System.out.println("=========================================");
        List<String> strings = Arrays.asList("abc", "", "bc", "efg", "abcd","", "jkl");
        long count = strings.stream().filter(string -> !StringUtils.isEmpty(string)).count();
        System.out.println(count);
        System.out.println("=========================================");
        List<String> collect = strings.stream().filter(string -> !StringUtils.isEmpty(string)).collect(Collectors.toList());
        collect.stream().forEach(System.out::println);
    }

}

