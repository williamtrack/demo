package com.charles.demo.thread;

public class SynchronizedTest {
    private static final Object mSync = new Object();

    public static void run() {
        System.out.println("Hello world!");
        final syncTest test = new syncTest();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method1();
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                test.method2();
            }
        }).start();
    }

    public static void run2() throws InterruptedException {
        new Thread(new Runnable() {
            @Override
            public void run() {
                //synchronized 修饰代码块
                synchronized (mSync) {
                    System.out.println("abc");
                    try {
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    public static void run3() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                synchronized (mSync) {
                    System.out.println("cba");
                }
            }
        }).start();
    }

}

//其他线程来访问synchronized修饰的其他方法时需要等待线程1先把锁释放
class syncTest {
    public synchronized void method1() {
        System.out.println(Thread.currentThread().getName() + " id: " + Thread.currentThread().getId());
        System.out.println("Method 1 start");
        try {
            System.out.println("Method 1 execute");
            Thread.sleep(3000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 1 end");
    }

    public synchronized void method2() {
        System.out.println(Thread.currentThread().getName() + " id: " + Thread.currentThread().getId());
        System.out.println("Method 2 start");
        try {
            System.out.println("Method 2 execute");
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Method 2 end");
    }
}
