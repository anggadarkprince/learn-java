package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        int iteration = 3;

        MyThread thread = new MyThread();
        thread.start();

        try {
            Thread.sleep(2500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        thread.interrupt();
        System.out.println("Called interrupt");

        MyRunnable runnable = new MyRunnable();
        new Thread(runnable).start();

        try {
            for (int i = 0; i < iteration; i++) {
                System.out.println("From main thread " + i);
                Thread.sleep(3000);
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        TargetClass target = new TargetClass();
        MyThreadSync threadSync1 = new MyThreadSync(1, target);
        MyThreadSync threadSync2 = new MyThreadSync(2, target);
        MyThreadSync threadSync3 = new MyThreadSync(3, target);
        threadSync1.start();
        threadSync2.start();
        threadSync3.start();
    }
}
