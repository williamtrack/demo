package com.charles.demo.test;

import java.lang.ref.SoftReference;
import java.lang.ref.WeakReference;

//  Created by Charles on 10/19/2020.
//  mail: zingon@163.com
public class WeakReferenceTest {
    public static void test() {
        WeakReference<String> st = new WeakReference<String>(new String("car"));
//        WeakReference<String> st = new WeakReference<String>("car"); //这种写法无法回收 why
        int i = 0;
        while (st.get() != null) {
            if (st.get() != null) {
                i++;
                System.out.println("Object is alive for " + i + " loops - " + st);
//                if (i % 10000 == 0) {
//                    System.gc();
//                }
            } else {
                System.out.println("Object has been collected.");
                break;
            }
        }
        System.out.println("end");

//        WeakReference<String> st = new WeakReference<String>(new String("hello"));
//        System.out.println(st.get());
//        System.gc();
//        Runtime.getRuntime().gc();
//        System.out.println(st.get());
    }

    public static void test2() {
        String obj = new String("abc"); //强引用
        SoftReference<String> st = new SoftReference<String>(obj); //只有内存不足的时候才会回收,gc不回收
//        WeakReference<String> sr = new WeakReference<String>(obj); //gc立即回收
        obj = "aaa";
        System.gc();
        System.out.println(obj);
        System.out.println(st.get());
        System.out.println(st);
    }

    static class Obj {
        int[] obj;

        public Obj() {
            obj = new int[1000];
        }
    }
}
