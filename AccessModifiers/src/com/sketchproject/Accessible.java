package com.sketchproject;

/**
 * AccessModifiers
 * Created by Angga on 25/07/2016.
 *
 * Challenge:
 * I the following interface declaration, what is the visibility of:
 *
 * 1. the Accessible interface?
 * 2. the int variable SOME_CONSTANT?
 * 3. methodA?
 * 4. methodB and methodC?
 */
interface Accessible {
    int SOME_CONSTANT = 100;
    public void methodA();
    void methodB();
    boolean methodC();
}
