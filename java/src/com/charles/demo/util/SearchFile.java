package com.charles.demo.util;

import com.charles.demo.Constant;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

//从md文件中找有效的img路径, 并删除md_img文件夹中删掉无效的文件
public class SearchFile {
    static String path = Constant.path_res;
    static String regExp = "gin(?<!=begin)linux(?!2).*d";
    static String str_find = "linux";

    static List<String> files_find = new ArrayList<>();
    static List<String> files_all = new ArrayList<>();
    static List<String> files_linux = new ArrayList<>();

    static String path2 = Constant.path_res + "b.txt";
    static String regExp2 = "\\b\\w+(?=123)"; //后面是123的字符
//    static String regExp2 = "(?<=hello)\\w+"; //前面是hello的字符
//    static String regExp2 = ".{3}(?<=begin)linux(?!2).*"; //后面不是2的字符 再全部 再后面是end的字符

    public static void test() {
        //==========test1: 搜索, 正则, 匹配
//        getAllFile(new File(path), file -> {
//            files_all.add(file.getName());
//            scanJob2(file,str_find);
//        });
//        getAllFile(new File(path), file -> {
//            files_linux.add(file.getName());
//        });
//        getAllFile(new File(path), file -> {
//            scanJob(file, regExp, files_find);
//        });
//        System.out.println("\n======");
//        System.out.println("files_all sizes: " + files_all.size());
//        System.out.println("files_linux sizes: " + files_linux.size());
//        System.out.println("files_find sizes: " + files_find.size());
//        for (String each : files_find) {
//            files_linux.removeIf(str -> str.equals(each)); //需要用迭代器removeIf,直接files_img.remove("")会报错
//        }
//        System.out.println("find sizes: " + files_linux.size());

        //==========test2: 正则表达式测试
        getAllFile(new File(path), file -> {
            if(file.getAbsolutePath().equals(path2)) scanJob(file, regExp2);
        });
    }

    public interface IFindFile {
        void find(File file);
    }

    //获取所有文件
    public static void getAllFile(File a, IFindFile iFindFile) {
        File[] files = a.listFiles();
        if (files == null) return;
        for (File file : files) {
            if (file.isFile()) {
                iFindFile.find(file);
            }
            if (file.isDirectory()) {//若a是目录，则对其目录下的目录或文件继续查找
                getAllFile(file, iFindFile);
            }
        }
    }

    //正则表达式
    static void scanJob(File file, String str) {
        try {
            Scanner scanner = new Scanner(file, "utf-8");
//            Scanner scanner = new Scanner(file, "gbk");
            while (scanner.hasNext()) {
                Pattern p = Pattern.compile(str);
                Matcher m = p.matcher(scanner.nextLine());
                while (m.find()) {
                    String s = m.group();
                    System.out.println(s);
                    System.out.println("===");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    //字符包含 contains
    static int m = 0;

    static void scanJob2(File file, String str) {
        try {
            Scanner scanner = new Scanner(file, "utf-8");
            int k = 0;
            while (scanner.hasNext()) {
                String s = scanner.nextLine();
                k++;
                if (s.contains(str)) {
                    String ss = m + ".文件:" + file.getPath() + " 第" + k + "行 \n 内容：" + s;
                    System.out.println(ss);
                    m++;
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
