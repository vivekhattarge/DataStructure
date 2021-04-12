package com.merge.intervals;

import java.util.ArrayList;
import java.util.List;

public class InsertAndMergeInterval {

    public static void main(String[] args) {

      /*  List<Interval> input = new ArrayList<Interval>();
        input.add(new Interval(1, 3));
        input.add(new Interval(5, 7));
        input.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input, new Interval(4, 6)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();*/

        List<Interval> input1 = new ArrayList<Interval>();
        input1.add(new Interval(1, 3));
        input1.add(new Interval(5, 7));
        input1.add(new Interval(8, 12));
        System.out.print("Intervals after inserting the new interval: ");
        for (Interval interval : insert(input1, new Interval(4, 10)))
            System.out.print("[" + interval.start + "," + interval.end + "] ");
        System.out.println();


    }

    private static List<Interval> insert(List<Interval> inputList, Interval interval) {

        List<Interval> mergedIntervals = new ArrayList<>();

        int i=0;

        while (i< inputList.size() && inputList.get(i).getEnd() < interval.getStart()){
            mergedIntervals.add(new Interval(inputList.get(i).getStart(),inputList.get(i).getEnd()));
            i++;
        }

        while(i<inputList.size() && inputList.get(i).getStart() <= interval.getEnd()){
            interval.start = Math.min(interval.getStart(), inputList.get(i).getStart());
            interval.end = Math.max(interval.getEnd(), inputList.get(i).getEnd());
            i++;
        }
        mergedIntervals.add(new Interval(interval.start, interval.end));

        while (i<inputList.size()){
            mergedIntervals.add(new Interval(inputList.get(i).getStart(),inputList.get(i).getEnd()));
            i++;
        }

        return mergedIntervals;
    }

    static class Interval {

        int start;
        int end;

        Interval(int start,int end){
            this.start = start;
            this.end = end;
        }

        public int getStart() {
            return start;
        }

        public void setStart(int start) {
            this.start = start;
        }

        public int getEnd() {
            return end;
        }

        public void setEnd(int end) {
            this.end = end;
        }
    }
}
