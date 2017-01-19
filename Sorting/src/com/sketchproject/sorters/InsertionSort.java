package com.sketchproject.sorters;

import com.sketchproject.interfaces.Isortable;

/**
 * Created by angga on 19/01/17.
 */
public class InsertionSort implements Isortable {
    @Override
    public int[] sort(int[] data) {
        for (int i = 1; i < data.length; i++) {
            int temp = data[i];
            int swappedIndex = i - 1;
            while (swappedIndex >= 0 && temp < data[swappedIndex]) {
                data[swappedIndex + 1] = data[swappedIndex];
                swappedIndex--;
            }
            data[swappedIndex + 1] = temp;
        }
        return data;
    }
}
