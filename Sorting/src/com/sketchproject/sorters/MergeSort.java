package com.sketchproject.sorters;

import com.sketchproject.interfaces.Isortable;

/**
 * Created by angga on 19/01/17.
 */
public class MergeSort implements Isortable {
    private int[] array;
    private int[] tempArray;

    @Override
    public int[] sort(int[] data) {
        array = data;
        tempArray = new int[data.length];
        split(0, data.length - 1);
        return array;
    }

    private void split(int left, int right) {
        // all data maximum split into single value (eg. 0-1, 4-5), if it's not it would run forever
        if (left < right) {
            int middle = (left + right) / 2;
            split(left, middle);
            split(middle + 1, right);
            merger(left, middle + 1, right);
        }
    }

    private void merger(int left, int middle, int right) {
        int minEnd = middle - 1;
        int index = left;

        while (left <= minEnd && middle <= right) {
            if (array[left] < array[middle]) {
                tempArray[index++] = array[left++];
            } else {
                tempArray[index++] = array[middle++];
            }
        }

        while (left <= minEnd) {
            tempArray[index++] = array[left++];
        }

        while (middle <= right) {
            tempArray[index++] = array[middle++];
        }

        int num = right - left + 1;
        for (int i = 0; i <= num; i++) {
            array[right] = tempArray[right];
            right--;
        }
    }
}
