package com.sketchproject.sorters;

import com.sketchproject.interfaces.Isortable;

/**
 * Created by angga on 19/01/17.
 */
public class QuickSort implements Isortable {
    private int array[];

    @Override
    public int[] sort(int[] data) {
        this.array = data;
        quickSort(0, data.length - 1);
        return array;
    }

    private void quickSort(int lowerIndex, int higherIndex) {
        int lower = lowerIndex;
        int higher = higherIndex;

        // calculate pivot number, I am taking pivot as middle index number
        int middle = (higherIndex + lowerIndex) / 2;
        int pivot = array[middle];

        // Divide into two arrays
        while (lower <= higher) {
            /**
             * In each iteration, we will identify a number from left side which
             * is greater then the pivot value, and also we will identify a number
             * from right side which is less then the pivot value. Once the search
             * is done, then we exchange both numbers.
             */
            while (array[lower] < pivot) {
                lower++;
            }
            while (array[higher] > pivot) {
                higher--;
            }
            if (lower <= higher) {
                int temp = array[lower];
                array[lower] = array[higher];
                array[higher] = temp;

                //move index to next position on both sides
                lower++;
                higher--;
            }
        }
        // call quickSort() method recursively
        if (lowerIndex < higher) {
            quickSort(lowerIndex, higher);
        }
        if (higherIndex > lower) {
            quickSort(lower, higherIndex);
        }
    }
}
