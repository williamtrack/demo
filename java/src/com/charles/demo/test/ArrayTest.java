package com.charles.demo.test;

import java.util.Arrays;

public class ArrayTest {
    public int arg;
    public static void run(){
        int p1[]=new int [5];
        p1[0]=11;
        p1[1]=13;
        p1[2]=12;
        Arrays.sort(p1,2,5);
        for(int x=0;x<p1.length;x++){
            System.out.println(p1[x]);
        }
        Outer a=new Outer();
        a.fun();
    }
}

class Outer{
    private int a=10;
    void fun(){
        final int num = 5;
        Inner a=new Inner();
        a.testNum();
    }
    //内部类
    class Inner{
        private int a=20;
        private int num = 4;
        public void testNum(){
            System.out.println(this.num);
            System.out.println(Outer.this.a);
        }
    }
}