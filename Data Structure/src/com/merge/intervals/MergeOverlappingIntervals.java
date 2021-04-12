package com.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        List<InsertAndMergeInterval.Interval> input = new ArrayList<InsertAndMergeInterval.Interval>();
        input.add(new InsertAndMergeInterval.Interval(1, 4));
        input.add(new InsertAndMergeInterval.Interval(2, 5));
        input.add(new InsertAndMergeInterval.Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (InsertAndMergeInterval.Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");

    }

    private static List<InsertAndMergeInterval.Interval>  merge(List<InsertAndMergeInterval.Interval> intervals) {
        List<InsertAndMergeInterval.Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        Iterator<InsertAndMergeInterval.Interval> intervalIterator = intervals.iterator();

        InsertAndMergeInterval.Interval firstInterval = intervalIterator.next();
        int start = firstInterval.getStart();
        int end = firstInterval.getEnd();

        while(intervalIterator.hasNext()){
            InsertAndMergeInterval.Interval interval = intervalIterator.next();

            if(interval.getStart() <= end){
                end = Math.max(end,interval.getEnd());
            }else{
                mergedIntervals.add(new InsertAndMergeInterval.Interval(start,end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        mergedIntervals.add(new InsertAndMergeInterval.Interval(start,end));
        return mergedIntervals;
    }

}
