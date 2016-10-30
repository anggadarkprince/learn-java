package com.sketchproject;

import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int[] myIntArray = new int[10];
        myIntArray[0] = 4;
        myIntArray[1] = 12;
        myIntArray[3] = 8;
        myIntArray[5] = 10;
        System.out.println(myIntArray[4]);
        System.out.println(myIntArray[5]);

        myIntArray[5] = 3;
        System.out.println(myIntArray[5]);

        double[] myDoubleArray = new double[10];
        for (int i = 0; i < myDoubleArray.length; i++) {
            myDoubleArray[i] = Math.random();
        }

        System.out.println();

        int[] completeArray = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};
        for (int j = 0; j < completeArray.length; j++) {
            System.out.println("Element " + j + ", value is " + completeArray[j]);
        }

        System.out.println();

        for (int aCompleteArray : completeArray) {
            System.out.println("Element value is " + aCompleteArray);
        }

        System.out.println();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Type number of name in collection : ");
        String[] collection = new String[0];

        try {
            collection = new String[scanner.nextInt()];
        } catch (Exception error) {
            System.err.println("Input must be a number");
        }

        for (int i = 0; i < collection.length; i++) {
            System.out.print("Type name collection number " + (i + 1) + " : ");
            collection[i] = scanner.next();
        }

        if (collection.length > 0) {
            System.out.println();
            System.out.println("Collection of Name :");
            for (String name : collection) {
                System.out.println(name);
            }
        } else {
            System.out.println("No collection available");
        }
    }
}
