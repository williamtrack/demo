package com.charles.demo.thread;

//  Created by Charles on 10/19/2020.
//  mail: zingon@163.com
public class ThreadTest {
    private Thread thread;

    public ThreadTest() {
        thread = new Thread(() -> {
//            try {
//                Thread.sleep(3000);
//            } catch (InterruptedException e) {
//                Log.d("Will", "中断");
//                //e.printStackTrace();
//            }
            while (!thread.isInterrupted()) {
                // 执行任务...
                //Log.d("Will", "-- "+thread.isInterrupted());
            }
            System.out.println("stop");
        });
    }

    public void interrupt() {
        thread.setName("childThread");
        thread.start();
        System.out.println(""+Thread.activeCount());
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        if (!thread.isInterrupted()) {
            System.out.println("主线程开始中断子线程");
            thread.interrupt();
        }
        try {
            Thread.sleep(1);
            System.out.println(""+Thread.activeCount() + thread.isAlive() + thread.isInterrupted());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
