package com.sketchproject;

public class Main {

    public static int multipler = 5;

    public static void main(String[] args) {
	    StaticTest firstInstance = new StaticTest("1st Instance");
        System.out.println(firstInstance.getName() + " is instance number " + firstInstance.getNumInstances());

        StaticTest secondInstance = new StaticTest("2nd Instance");
        System.out.println(secondInstance.getName() + " is instance number " + secondInstance.getNumInstances());

        StaticTest thirdInstance = new StaticTest("3nd Instance");
        System.out.println(thirdInstance.getName() + " is instance number " + StaticTest.getNumInstancesX2());

        // multiply(3); // cannot call non static method inside another static method
    }

    public int multiply(int number){
        return number * multipler;
    }
}
