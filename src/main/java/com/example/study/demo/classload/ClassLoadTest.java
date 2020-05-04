package com.example.study.demo.classload;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;
import java.util.ArrayList;
import java.util.Collection;

/**
 * Created by s94pcp on 2020/4/18.
 */
public class ClassLoadTest {

    public static void main(String[] args) {

        ArrayList coll=new ArrayList();
        Collection proxy= (Collection) Proxy.newProxyInstance(Collection.class.getClassLoader(), coll.getClass().getInterfaces(), new InvocationHandler() {
            @Override
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                return proxy;
            }
        });
        proxy.add("a");
        proxy.add("a");
        proxy.add("b");
        System.out.println(proxy.size());
    }
}
