package com.charles.demo.thread;

public class VolatileTest {
    static class VOT {
        volatile int value = 0;
        //synchronized 加上就能保证原子性
        void increase() {
            value++;
        }
    }

    public VolatileTest() {
        int num =Thread.activeCount();
        final VOT vot = new VOT();
        for (int i = 0; i < 10; i++) {
            new Thread(() -> {
                for (int j = 0; j < 1000; j++) {
                    vot.increase();
                }
                System.out.println("VolatileTest-run: " + vot.value);
            }).start();
        }
        //如果有子线程则让出资源
        while (Thread.activeCount() > num) {
            Thread.yield();
        }

        System.out.println("final value: " + vot.value);
    }
}
