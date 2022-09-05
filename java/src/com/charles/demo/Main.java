package com.charles.demo;

import com.charles.demo.frame.UITest;
import com.charles.demo.demo.ImageToStr;
import com.charles.demo.demo.SearchFileMdImg;
import com.charles.demo.util.SearchFile;

public class Main {

    public static void main(String[] args) {
//        new UITest();
        myDemo();
        for (String i : args) {
            System.out.println("arg is" + i);
        }
        System.out.print("===");
    }

    static void myDemo() {
//        SearchFile.test();
//        SearchFileMdImg.test();
//        ImageToStr.test();
    }
}
