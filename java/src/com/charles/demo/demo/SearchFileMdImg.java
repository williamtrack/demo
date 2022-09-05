package com.charles.demo.demo;

import com.charles.demo.util.SearchFile;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//从md文件中找有效的img路径, 并删除md_img文件夹中删掉无效的文件
public class SearchFileMdImg {
    static String path = "D:\\data\\md\\md";
    static String path_img = "D:\\data\\md\\md_img\\img";
    static String regExp = "(?<=\\.\\.\\/\\.\\.\\/\\.\\.\\/md_img\\/img\\/)(.*?)(?=\\))";

    static List<String> files_find = new ArrayList<>();
    static List<String> files_all = new ArrayList<>();
    static List<String> files_img = new ArrayList<>();

    public static void test() {
        SearchFile.getAllFile(new File(path), file -> {
            files_all.add(file.getName());
        });
        SearchFile.getAllFile(new File(path_img), file -> {
            files_img.add(file.getName());
        });
        SearchFile.getAllFile(new File(path), file -> {
            try {
                Scanner scanner = new Scanner(file, "utf-8");
                while (scanner.hasNext()) {
                    Pattern p = Pattern.compile(regExp);
                    Matcher m = p.matcher(scanner.nextLine());
                    while (m.find()) {
                        String s = m.group();
                        System.out.println(s);
                        files_find.add(s);
                    }
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
        System.out.println("\n======");
        System.out.println("files_all sizes = " + files_all.size());
        System.out.println("files_img sizes = " + files_img.size());
        System.out.println("files_find sizes = " + files_find.size());
        for (String each : files_find) {
            files_img.removeIf(str -> str.equals(each)); //需要用迭代器removeIf,直接files_img.remove("")会报错
        }
        System.out.println("delete sizes: " + files_img.size());
        for (String a : files_img) {  //delete unnecessary files
            File file = new File(path_img + "\\" + a);
            file.delete();
        }
    }
}
