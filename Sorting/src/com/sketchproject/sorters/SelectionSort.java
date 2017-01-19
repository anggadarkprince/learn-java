package com.sketchproject.sorters;

import com.sketchproject.interfaces.Isortable;

/**
 * Created by angga on 19/01/17.
 */
public class SelectionSort implements Isortable {
    @Override
    public int[] sort(int[] data) {
        for(int i = 0; i < data.length; i++){
            int min = i;
            for(int j = i; j < data.length; j++){
                if(data[j] < data[min]){
                    min = j;
                }
            }
            if(min != i){
                int temp = data[i];
                data[i] = data[min];
                data[min] = temp;
            }
        }
        return data;
    }
}
