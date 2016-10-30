package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        // java has 50 keywords such as public, static, void, interface, class, abstract, int, long, float, byte, if, else, etc

        // a mile is equal to 1.609344 kilometres
        // statement is line of code which ended with semi colon (;) that contains variable, value and operator
        double kilometres = (100 * 1.609344);

        // expression is part of statement and code inside bracket except type data and semi colon
        int highscore = 50;
        if(highscore == 50){
            System.out.println("This is an expression");
        }

        // int the following code that I will type below, write down what parts of the core are expressions
        int score = 100; // score = 100 is expression, data type and semi colon IS NOT tha part of the expression
        if(score > 99){ // score > 99 is expression, bracket IS NOT part of the expression
            System.out.println("You got the high score!"); // "You got the high score!" whatever inside method bracket is expression
            score = 0; // score = 0 is expression
        }
    }
}
