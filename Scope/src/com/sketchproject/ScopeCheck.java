package com.sketchproject;

/**
 * Scope
 * Created by Angga on 25/07/2016.
 */
public class ScopeCheck {
    public int publicVar = 0;
    private int varOne = 1;

    public ScopeCheck() {
        System.out.println("ScopeCheck create, publicVar = " + publicVar + ": varOne = " + varOne);
    }

    public int getVarOne() {
        return varOne;
    }

    public void timesTwo() {
        // if we give a comment this variable they will be reference global private variable
        // outside this method (class level)
        int varTwo = 2; // different value with this.varOne
        for (int i = 0; i < 10; i++) {
            System.out.println(i + " times two is " + i * varTwo); // varOne access locally
        }

        //System.out.println("Value of i is now " + i); // getting error because out of scope
    }

    public void useInner(){
        InnerClass innerClass = new InnerClass();
        System.out.println("varThree from outer class: " + innerClass.varThree);
    }

    public class InnerClass {
        private int varThree = 3;

        public InnerClass() {
            System.out.println("InnerClass created, varOne is " + varOne + " and varThree is " + varThree);
        }

        public void timesTwo() {
            System.out.println("varOne is still available here " + varOne);
            for (int i = 0; i < 10; i++) {
                System.out.println(i + " times two is " + i * varThree);
            }
        }
    }
}