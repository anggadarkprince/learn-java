package com.sketchproject;

/**
 * Multithreading
 * Created by Angga on 26/07/2016.
 */
public class MyThreadSync extends Thread {
    private int threadId;
    private TargetClass target;

    public MyThreadSync(int threadId, TargetClass target) {
        this.threadId = threadId;
        this.target = target;
    }

    @Override
    public void run() {

        synchronized (target){
            try {
                sleep(2000);
            } catch (InterruptedException e) {
                System.err.println("Interrupted " + e.getMessage());
            }
        }
        target.call(threadId);

    }
}
