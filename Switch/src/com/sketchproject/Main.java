package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        int value = 1;
        if (value == 1) {
            System.out.println("Value was 1");
        } else if (value == 2) {
            System.out.println("Value was 2");
        } else {
            System.out.println("Was not 1 or 2");
        }

        System.out.println();

        int switchValue = 2;
        switch (switchValue) {
            case 1:
                System.out.println("Value was 1");
                //break;
            case 2:
                System.out.println("Value was 2");
                //break;
            case 3:
            case 4:
            case 5:
                System.out.println("Was a 3, or a 4, or a 5");
                System.out.println("Actually it was a " + switchValue);
                //break;
            default:
                System.out.println("Over than 5");
                //break;
        }

        // Create a new switch statement using char instead of int
        // create a new char variable
        // create a switch statement testing for
        // A, B, C, D, or E
        // display a message if any these are found and then break
        // And a default which displays a message saying not found

        char charValue = 'E';
        switch (charValue) {
            case 'A':
                System.out.println("A was found");
                break;
            case 'B':
                System.out.println("B was found");
                break;
            case 'C':
            case 'D':
            case 'E':
                System.out.println(charValue + " was found");
                break;
            default:
                System.out.println("Could not find A, B, C, D, or E");
                break;
        }

        String month = "JanuAry";
        switch(month.toLowerCase()){
            case "january":
                System.out.println("Jan");
                break;
            case "june":
                System.out.println("Jun");
                break;
            default:
                System.out.println("Not sure");
        }
    }
}
