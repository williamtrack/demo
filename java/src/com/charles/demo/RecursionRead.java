package com.charles.demo;


import java.io.*;
import java.util.HashMap;

/**
 * -William
 *
 * @Description 递归逐层遍历读取所有的文件并输出每一行的内容
 */
public class RecursionRead {
    private static int index = 0;
    private static String string = "";

    public static void doJob() throws IOException {
        File dir = new File("C:\\Users\\William\\Desktop\\boevrS");
        File target = new File("C:\\Users\\William\\Desktop\\test.txt");
        BufferedWriter bw = new BufferedWriter(new FileWriter(target));

        HashMap<String, String> map = new HashMap<String, String>();

        method1(dir, bw);
        method3(string, bw);
        //传入一个路径
        //readRecursion("C:\\Users\\William\\Desktop\\boevr\\utils");
    }

    // 遍历文件夹下所有文件,对于有内容的文件全部写到一个文本文件中。
    public static void method1(File dir, Writer writer) {
        File[] files = dir.listFiles();
        for (File file : files) {
            if (file.isDirectory()) {
                //子文件夹遍历
                method1(file, writer);
            } else {
                if (file.length() != 0) {
                    string = string + method2(file);
                }
            }

        }

    }

    //读取文件里面的内容
    public static String method2(File file) {
        BufferedReader br = null;
        StringBuffer sb = new StringBuffer();
        try {
            br = new BufferedReader(new FileReader(file));
            String line = null;
            index++;
            sb.append("源文件"+index + ":  "+file.getName()+"\r\n");
            while ((line = br.readLine()) != null) {
                sb.append(line);
                //添加换行符
                sb.append("\r\n");
            }
            sb.append("\r\n\r\n\r\n");
        } catch (Exception e) {
            // TODO: handle exception
            e.printStackTrace();
        } finally {
            try {
                if (br != null) {
                    br.close();
                }
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }
        return sb.toString();

    }

    //将读取的路径以及相应的内容写入指定的文件
    public static void method3(String str, Writer writer) {
        try {
            writer.write(str);
        } catch (Exception e) {
            // TODO: handle exception
        } finally {

            try {
                if (writer != null)
                    writer.close();
            } catch (Exception e2) {
                // TODO: handle exception
                e2.printStackTrace();
            }
        }

    }


    public static void readRecursion(String directory) throws IOException {
        File file = new File(directory);
        File outFile = new File("C:\\Users\\William\\Desktop\\test.txt");
        if (file.isDirectory()) {
            File[] fileArray = file.listFiles();
            for (File f : fileArray) {
                readRecursion(f.getAbsolutePath());
            }
        } else {
            System.out.println(file.getAbsolutePath());
            //字节输入流
            InputStream inputStream = new FileInputStream(file);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line;
            while ((line = bufferedReader.readLine()) != null) {
                System.out.println(line);
            }
        }
    }
}
