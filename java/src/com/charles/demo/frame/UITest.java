package com.charles.demo.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class UITest {
    public UITest(){
        Frame f = new Frame("这是一个Frame");
        f.setBackground(Color.BLUE);
        //f.setSize(300,200);
        f.setBounds(400, 200, 400, 300);
        f.setLayout(new FlowLayout());

        //创建文本框
        TextField tf = new TextField(20);
        //创建按钮
        Button bu = new Button("button");
        //创建文本域
        TextArea ta = new TextArea(10, 40);
        MenuBar menubar = new MenuBar();
        Menu menu= new Menu("文件");
        MenuItem item1=new MenuItem("打开");
        MenuItem item2=new MenuItem("关闭");
        menu.add(item1);
        menu.add(item2);
        menubar.add(menu);

        f.setMenuBar(menubar);
        f.add(tf);
        f.add(bu);
        f.add(ta);

        //给按钮添加实践
        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //获取文本框中的文本
                String tf_str = tf.getText().trim();
                tf.setText("");

                //将文本交给文本框
                //ta.setText(tf_str);
                //追加文本
                ta.append(tf_str+"\r\n");

                //将光标移动到tf文本框
                tf.requestFocus();
            }
        });

        f.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                super.windowOpened(e);
                System.exit(0);
            }
        });

        //设置窗体显示
        f.setVisible(true);
    }
}
