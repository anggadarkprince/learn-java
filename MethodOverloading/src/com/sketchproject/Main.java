package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        calculateScore("Angga");
        calculateScore(300);
        int newScore = calculateScore("Angga", 500);
        System.out.println("New score is " + newScore);

        calcFeetAndInchesToCentimeters(7, -5);

        calcFeetAndInchesToCentimeters(100);

        // Create a method called calcFeetAndInchesToCentimeters
        // It needs to have two parameters
        // feet is the first parameter, inches is the 2nd parameter
        //
        // You should validate that the first parameter feet is >= 0
        // You should validate that the 2nd parameter inches is >= 0 and <= 12
        // return -1 from the method if either of the above is not true
        //
        // If the parameters are valid, then calculate how many centimetres
        // comprise the feet and inches passed to this method and return that value
        //
        // Create a 2nd method of the same name but with only one parameter
        // inches is the parameter
        // validate that its >= 0
        // return -1 if it is not true
        // But id its valid, then calculate how many feet are in the inches
        // and then here is the tricky part
        // call the other overloaded method passing the correct feet and inches
        // calculated so that it can calculate correctly
        // hints: use double for your number data types is probably a good idea
        // 1 inch = 2.54cm and one foot = 12 inches
        // use the link www.metric-conversions.org to confirm your code is calculating correctly.
        // calling another overloaded method just requires you to use the right number of parameters.
    }

    public static double calcFeetAndInchesToCentimeters(double feet, double inches) {
        if (feet < 0 || (inches < 0 || inches > 12)) {
            System.out.println("Invalid feet or inches parameters");
            return -1;
        }

        double centimeters = (feet * 12) * 2.54;
        centimeters += inches * 2.54;
        System.out.println(feet + " feet, " + inches + " inches = " + centimeters + " cm");
        return centimeters;
    }

    public static double calcFeetAndInchesToCentimeters(double inches) {
        if (inches < 0) {
            System.out.println("Invalid inches parameters");
            return -1;
        }

        double feet = (int) inches / 12;
        double remainingInches = (int) inches % 12;
        System.out.println(inches + " inches is equal to " + feet + " feet and remaining " + remainingInches + " inches");
        return calcFeetAndInchesToCentimeters(feet, remainingInches);
    }

    public static int calculateScore(String playerName) {
        System.out.println("Player " + playerName + " scored " + 0 + " points");
        return 0;
    }

    public static int calculateScore(int score) {
        System.out.println("Unnamed player scored " + score + " points");
        return score;
    }

    public static int calculateScore(String playerName, int score) {
        System.out.println("Player " + playerName + " scored " + score + " points");
        return score * 1000;
    }
}
