package com.sketchproject;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Integer> data1 = new ArrayList<>();
        data1.add(1);
        data1.add(2);
        data1.add(3);
        System.out.println("Data 1: " + data1.toString());

        List<Integer> data2 = new ArrayList<>();
        data2.add(2);
        data2.add(3);
        data2.add(4);
        System.out.println("Data 2: " + data2.toString());

        CollectionOperator<Integer> operator = new CollectionOperator<>();

        System.out.println("Union");
        List<Integer> union = operator.union(data1, data2);
        System.out.println(union.toString());

        System.out.println("Intersect");
        List<Integer> intersect = operator.intersect(data1, data2);
        System.out.println(intersect.toString());

        System.out.println("Difference");
        List<Integer> difference = operator.difference(data1, data2);
        System.out.println(difference.toString());

        System.out.println("Symmetric Difference");
        List<Integer> symmetricDifference = operator.symmetricDifference(data1, data2);
        System.out.println(symmetricDifference.toString());
    }
}
