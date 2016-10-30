package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        String varFour = "This is private to main()"; // different value with varThree inside ScopeCheck class

        ScopeCheck scopeInstance = new ScopeCheck();
        scopeInstance.useInner();

        //ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        //System.out.println("varThree is not accessible here "+innerClass.varThree);

        System.out.println("scopeInstance varOne is " + scopeInstance.getVarOne());
        System.out.println(varFour);

        scopeInstance.timesTwo();

        System.out.println();

        ScopeCheck.InnerClass innerClass = scopeInstance.new InnerClass();
        innerClass.timesTwo();
    }
}
