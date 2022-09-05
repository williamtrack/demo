package com.charles.demo.thread;

import java.util.concurrent.ArrayBlockingQueue;

//  Created by Charles on 10/19/2020.
//  mail: zingon@163.com
public class ArrayBlockingQueueTest {
    private int queueSize = 10;
    //private final PriorityQueue<Integer> queue = new PriorityQueue<Integer>(queueSize);
    private ArrayBlockingQueue<Integer> queue= new ArrayBlockingQueue<>(queueSize);
    //private LinkedBlockingQueue<Integer> queue= new LinkedBlockingQueue<>();

    public ArrayBlockingQueueTest() {
        Producer producer=new Producer();
        Consumer consumer=new Consumer();
        producer.setName("producer");
        consumer.setName("consumer");
        producer.start();
        consumer.start();
    }

    class Consumer extends Thread {
        @Override
        public void run() {
            super.run();
            while (true) {
                try {
                    sleep(400);
                    queue.take();
                    System.out.println("Consumer: "+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

    class Producer extends Thread{
        @Override
        public void run() {
            super.run();
            while (true){
                try {
                    sleep(100);
                    queue.put(1);
                    System.out.println("Producer: "+queue.size());
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }

//    class Consumer extends Thread {
//        @Override
//        public void run() {
//            super.run();
//            while (true) {
//                synchronized (queue) {
//                    //Log.d("Will", "--"+queue.size());
//                    while (queue.size() == 0) {
//                        Log.d("Will", "队列空，等待数据");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            queue.notify();
//                        }
//                    }
//                    //每次移走队首元素
//                    queue.poll();
//                    queue.notify();
//                }
//            }
//        }
//    }
//
//    class Producer extends Thread{
//        @Override
//        public void run() {
//            super.run();
//            while (true){
//                synchronized (queue){
//                    //Log.d("Will", "=="+queue.size());
//                    while (queue.size()==queueSize){
//                        Log.d("Will", "队列慢，等待空余空间");
//                        try {
//                            queue.wait();
//                        } catch (InterruptedException e) {
//                            e.printStackTrace();
//                            queue.notify();
//                        }
//                    }
//                    //每次插入一个元素
//                    queue.offer(1);
//                    queue.notify();
//                }
//            }
//        }
//    }
}
