package com.sketchproject;

/**
 * Multithreading
 * Created by Angga on 26/07/2016.
 */
public class MyThread extends Thread {

    @Override
    public void run() {
        int iteration = 5;
        try {
            for (int i = 0; i < iteration; i++) {
                System.out.println("From secondary thread " + i);
                sleep(2000);
            }
        } catch (InterruptedException e) {
            System.err.println("Interrupted " + e.getMessage());
        }
    }
}
