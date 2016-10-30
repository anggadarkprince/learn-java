package com.sketchproject;

/**
 * Multithreading
 * Created by Angga on 26/07/2016.
 */
public class TargetClass {
    public void call(int threadId){
        System.out.println("Calling thread from " + threadId);
    }
}
