package com.sketchproject;

/**
 * Testing
 * Created by Angga on 26/07/2016.
 */
public class WrongFileException extends Exception {
    public static final long serialVersionUID = 42L;

    @Override
    public String getMessage() {
        return "You choose the wrong file!";
    }
}
