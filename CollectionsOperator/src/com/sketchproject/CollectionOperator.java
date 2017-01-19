package com.sketchproject;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by angga on 19/01/17.
 */
public class CollectionOperator<T> {

    public List<T> union(List<T> data1, List<T> data2) {
        List<T> merge = new ArrayList<>();
        merge.addAll(data1);
        for (T value : data2) {
            if (!merge.contains(value)) {
                merge.add(value);
            }
        }
        return merge;
    }

    public List<T> intersect(List<T> data1, List<T> data2) {
        List<T> same = new ArrayList<>();
        for (T value1 : data1) {
            for (T value2 : data2) {
                if(value1 == value2){
                    same.add(value1);
                }
            }
        }
        return same;
    }

    public List<T> difference(List<T> data1, List<T> data2) {
        List<T> anomaly = new ArrayList<>();
        for (T value1 : data1) {
            boolean flag = true;
            for (T value2 : data2) {
                if(value1 == value2){
                    flag = false;
                }
            }
            if(flag){
                anomaly.add(value1);
            }
        }
        return anomaly;
    }

    public List<T> symmetricDifference(List<T> data1, List<T> data2) {
        List<T> in = intersect(data1, data2);
        List<T> un = union(data1, data2);

        return difference(un, in);
    }
}
