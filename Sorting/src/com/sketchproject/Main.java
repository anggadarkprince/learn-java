package com.sketchproject;

import com.sketchproject.interfaces.Isortable;
import com.sketchproject.sorters.*;

public class Main {

    public static void main(String[] args) {
        Isortable sorter = new QuickSort();
        print(sorter.sort(generator()));
    }

    public static int[] generator(){
        int[] data = new int[10];
        for (int i = 0; i < data.length; i++){
            data[i] = (int) Math.floor(Math.random() * 100);
        }
        System.out.println("Before Sorted:");
        print(data);
        return data;
    }

    public static void print(int[] dataSorted){
        System.out.println("After Sorted:");
        for (int i = 0; i<dataSorted.length; i++){
            System.out.print(dataSorted[i] + " ");
        }
        System.out.println();
    }
}
