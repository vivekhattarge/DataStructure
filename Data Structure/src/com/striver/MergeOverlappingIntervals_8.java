package com.striver;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class MergeOverlappingIntervals_8 {

    public static void main(String args[]) {
        ArrayList <List< Integer >> arr = new ArrayList<>();
        arr.add(Arrays.asList(new Integer[]{1,3}));
        arr.add(Arrays.asList(new Integer[]{2,4}));
        arr.add(Arrays.asList(new Integer[]{2,6}));
        arr.add(Arrays.asList(new Integer[]{8,9}));
        arr.add(Arrays.asList(new Integer[]{8,10}));
        arr.add(Arrays.asList(new Integer[]{9,11}));
        arr.add(Arrays.asList(new Integer[]{15,18}));
        arr.add(Arrays.asList(new Integer[]{16,17}));
        ArrayList < List < Integer >> ans = merge(arr);
        System.out.println("Merged Overlapping Intervals are ");
        for (List < Integer > it: ans) {
            System.out.println(it.get(0) + " " + it.get(1));
        }
    }

    private static ArrayList<List<Integer>> merge(ArrayList<List<Integer>> intervals) {

        Collections.sort(intervals,(a,b)->a.get(0)-b.get(0));

        ArrayList<List<Integer>> pairs = new ArrayList<>();

        for(List<Integer> interval : intervals){

            if(pairs.isEmpty() || pairs.get(pairs.size()-1).get(1) < interval.get(0)){

                List<Integer> pair = new ArrayList<>();
                pair.add(interval.get(0));
                pair.add(interval.get(1));

                pairs.add(pair);
            }else{
               pairs.get(pairs.size()-1).set(1, Math.max( pairs.get(pairs.size()-1).get(1), interval.get(1)));
            }
        }
        return pairs;
    }


}
