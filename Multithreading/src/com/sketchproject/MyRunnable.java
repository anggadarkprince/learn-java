package com.sketchproject;

/**
 * Multithreading
 * Created by Angga on 26/07/2016.
 */
public class MyRunnable implements Runnable {
    @Override
    public void run() {
        int iteration = 5;
        try {
            for (int i = 0; i < iteration; i++) {
                System.out.println("From runnable thread " + i);
                Thread.sleep(1500);
            }
        } catch (InterruptedException e) {
            System.err.println(e.getMessage());
        }
    }
}
