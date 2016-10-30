package com.sketchproject;

import java.util.ArrayList;

class IntClass{
    private int myValue;

    public IntClass(int myValue) {
        this.myValue = myValue;
    }

    public int getMyValue() {
        return myValue;
    }

    public void setMyValue(int myValue) {
        this.myValue = myValue;
    }
}

public class Main {

    public static void main(String[] args) {
	    String[] strArray = new String[10];
        int[] intArray = new int[10];

        ArrayList<String> strArrayList = new ArrayList<>();
        strArrayList.add("Angga");

        ArrayList<IntClass> intArrayList = new ArrayList<>();
        intArrayList.add(new IntClass(45));

        Integer integer = new Integer(22);
        Double newDouble = 2.4;

        ArrayList<Integer> integerList = new ArrayList<>();
        for (int i = 0; i <= 10; i++){
            integerList.add(Integer.valueOf(i));
        }

        for (int i = 0; i <= 10; i++){
            System.out.println(i+" -> "+integerList.get(i).intValue());
        }

        Integer myIntValue = 56; // Integer.valueOf(56);
        int myInt = myIntValue; // myIntValue.intValue();
    }
}
