package com.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;

public class MergeOverlappingIntervals {

    public static void main(String[] args) {

        List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 4));
        input.add(new Interval(2, 5));
        input.add(new Interval(7, 9));
        System.out.print("Merged intervals: ");
        for (Interval interval : merge(input))
            System.out.print("[" + interval.start + "," + interval.end + "] ");

    }

    private static List<Interval>  merge(List<Interval> intervals) {
        List<Interval> mergedIntervals = new ArrayList<>();

        Collections.sort(intervals,(a,b) -> Integer.compare(a.start,b.start));
        Iterator<Interval> intervalIterator = intervals.iterator();

        Interval firstInterval = intervalIterator.next();
        int start = firstInterval.getStart();
        int end = firstInterval.getEnd();

        while(intervalIterator.hasNext()){
            Interval interval = intervalIterator.next();

            if(interval.getStart() <= end){
                end = Math.max(end,interval.getEnd());
            }else{
                mergedIntervals.add(new Interval(start,end));
                start = interval.getStart();
                end = interval.getEnd();
            }
        }
        mergedIntervals.add(new Interval(start,end));
        return mergedIntervals;
    }

}
