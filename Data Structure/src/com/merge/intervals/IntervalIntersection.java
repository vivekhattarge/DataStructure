package com.merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class IntervalIntersection {

    public static void main(String[] args) {

        List<InsertAndMergeInterval.Interval> input1 = new ArrayList<>();
        input1.add(new InsertAndMergeInterval.Interval(1, 3));
        input1.add(new InsertAndMergeInterval.Interval(5, 6));
        input1.add(new InsertAndMergeInterval.Interval(7, 9));

        List<InsertAndMergeInterval.Interval> input2 = new ArrayList<>();
        input2.add(new InsertAndMergeInterval.Interval(2, 3));
        input2.add(new InsertAndMergeInterval.Interval(5, 7));
        List<InsertAndMergeInterval.Interval> result = IntervalIntersection.merge(input1, input2);
        System.out.print("Intervals Intersection: ");
        for (InsertAndMergeInterval.Interval interval : result)
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();

    }

    private static List<InsertAndMergeInterval.Interval> merge(List<InsertAndMergeInterval.Interval> input1, List<InsertAndMergeInterval.Interval> input2) {
        List<InsertAndMergeInterval.Interval> mergedIntervals = new ArrayList<>();

        int i = 0;
        int j = 0;
        while( i < input1.size() && j< input2.size()){
            if ((input1.get(i).start >= input2.get(j).start &&
                    input1.get(i).start <= input2.get(j).end) ||
                    (input2.get(j).start >= input1.get(i).start &&
                            input2.get(j).start <= input1.get(i).end)) {

                mergedIntervals.add(new InsertAndMergeInterval.Interval(Math.max(input1.get(i).getStart(), input2.get(j).getStart()),
                        Math.min(input1.get(i).getEnd(), input2.get(j).getEnd())));

            }
            if (input1.get(i).getEnd() < input2.get(j).getEnd()) {
                i++;
            } else {
                j++;
            }
        }

        return mergedIntervals;
    }


}
