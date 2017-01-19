package com.sketchproject.sorters;

import com.sketchproject.interfaces.Isortable;

/**
 * Created by angga on 19/01/17.
 */
public class BubbleSort implements Isortable {

    @Override
    public int[] sort(int[] data) {
        int countSwapping = 0;
        int countIteration = 0;
        boolean isAlreadySorted;

        for (int i = 0; i < data.length; i++) {
            isAlreadySorted = true;
            for (int j = 1; j < data.length - i; j++) {
                countIteration++;

                if (data[j] < data[j - 1]) {
                    int temp = data[j - 1];
                    data[j - 1] = data[j];
                    data[j] = temp;

                    isAlreadySorted = false;
                    countSwapping++;
                }
            }
            if (isAlreadySorted) {
                break;
            }
        }
        System.out.println("Swapping total " + countSwapping);
        System.out.println("Iteration total " + countIteration);
        return data;
    }

    /**
     * More iteration process because there is no optimisation trimmed index
     * @param data
     * @return
     */
    public int[] anotherBubbleSort(int[] data) {
        int countSwapping = 0;
        int countIteration = 0;
        boolean swapped;
        do {
            swapped = false;
            for (int i = 1; i < data.length; i++) {
                countIteration++;

                if (data[i - 1] > data[i]) {
                    int temp = data[i - 1];
                    data[i - 1] = data[i];
                    data[i] = temp;

                    swapped = true;
                    countSwapping++;
                }
            }
        } while (swapped);

        System.out.println("Swapping total " + countSwapping);
        System.out.println("Iteration total " + countIteration);
        return data;
    }
}
