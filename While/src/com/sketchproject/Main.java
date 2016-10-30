package com.sketchproject;

public class Main {

    public static void main(String[] args) {
        int count = 1;
        while (count != 6) {
            System.out.println("Count value is " + count);
            count++;
        }

        System.out.println();

        for (int i = 1; i < 6; i++) {
            System.out.println("Count value is " + i);
        }

        System.out.println();

        count = 1;
        while (true) {
            if (count == 5) {
                break;
            }
            System.out.println("Count value is " + count);
            count++;
        }

        System.out.println();

        count = 1;
        do {
            System.out.println("Count value was " + count);
            count++;
        } while (count > 6);

        // Create a method called isEvenNumber that takes a parameter of type int
        // Its purpose is to determine if the argument passed to the method is
        // and even or not
        // return if an even number, otherwise return false

        int number = 5;
        int finishNumber = 20;
        while (number <= finishNumber) {
            if (!isEvenNumber(number)) {
                number++;
                continue;
            }

            System.out.println("Even number " + number);
            number++;
        }

        System.out.println();

        // modify the while code above
        // make it also record the total number of even numbers it has found
        // and break once 5 are found
        // and at the end, display the total number of even numbers found

        number = 5;
        finishNumber = 20;
        int evenNumberFound = 0;
        while (number <= finishNumber) {
            if (!isEvenNumber(number)) {
                number++;
                continue;
            }

            System.out.println("Even number " + number);
            number++;

            evenNumberFound++;
            if(evenNumberFound >= 5){
                break;
            }
        }

        System.out.println("Total even number found " + evenNumberFound);
    }

    public static boolean isEvenNumber(int number) {
        if ((number % 2) == 0) {
            return true;
        } else {
            return false;
        }

    }
}
