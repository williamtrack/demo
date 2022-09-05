package com.charles.demo.thread;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/*
 *   Created by Charles on 09/07/2020.
 */
public class ExecutorServiceTest {
    public ExecutorServiceTest(){
//        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(2);
////        scheduledThreadPool.schedule(new Runnable() {
////            @Override
////            public void run() {
////                Log.d("will", "ExecutorServiceDemo-run: ");
////            }
////        }, 3, TimeUnit.SECONDS);
//        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
//            @Override
//            public void run() {
//                Log.d("will", "ExecutorServiceDemo-run: "+Thread.currentThread().getName());
//            }
//        },0,1000,TimeUnit.MILLISECONDS);

        ExecutorService fixedThreadPool = Executors.newFixedThreadPool(3);
        for (int i = 0; i < 10; i++) {
            final int index = i;
            fixedThreadPool.execute(new Runnable() {
                @Override
                public void run() {
                    try {
                        System.out.println(""+index);
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        // TODO Auto-generated catch block
                        e.printStackTrace();
                    }
                }
            });
        }
    }
}
