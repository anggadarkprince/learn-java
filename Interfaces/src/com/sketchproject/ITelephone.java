package com.sketchproject;

/**
 * Interfaces
 * Created by Angga on 24/07/2016.
 */
public interface ITelephone {
    void powerOn();
    void dial(int phoneNumber);
    void answer();
    boolean callPhone(int phoneNumber);
    boolean isRinging();
}
