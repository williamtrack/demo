package com.charles.demo.frame;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FrameTest {
    public FrameTest(IButtonJob iButtonJob){
        Frame f = new Frame("测试界面");
        f.setBounds(400, 200, 400, 300);
        f.setBackground(Color.WHITE);
        f.setLayout(new FlowLayout());

        Button bu = new Button("button");
        TextArea ta = new TextArea(10, 40);

        f.add(bu);
        f.add(ta);

        bu.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                iButtonJob.doJob();
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

    public interface IButtonJob{
        void doJob();
    }
}
