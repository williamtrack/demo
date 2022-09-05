package com.charles.demo.test;

public class ClassTest {
    static int pp=10;
    void f1(){
        //一旦对象调用了f1，则ClassTest的pp变量的值也会永久变化。
        pp=20;
        System.out.println("ClassTest pp: "+pp);
    }
    //接口测试
    interface InterfaceTest{
        void f2();
    }
}
