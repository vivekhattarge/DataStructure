package com.merge.intervals;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.PriorityQueue;

class Meeting {
    int start;
    int end;

    public Meeting(int start, int end) {
        this.start = start;
        this.end = end;
    }
};

public class MeetingRoomsCount {

    public static void main(String[] args) {

        List<Meeting> input = new ArrayList<Meeting>() {
            {
                add(new Meeting(4, 5));
                add(new Meeting(2, 3));
                add(new Meeting(2, 4));
                add(new Meeting(3, 5));
            }
        };
        int result = MeetingRoomsCount.findMinimumMeetingRooms(input);
        System.out.println("Minimum meeting rooms required: " + result);

    }

    private static int findMinimumMeetingRooms(List<Meeting> meetings) {

        Collections.sort(meetings, (a, b) -> Integer.compare(a.start, b.start));

        PriorityQueue<Meeting> minHeap = new PriorityQueue<>(meetings.size(), (a, b) -> Integer.compare(a.end, b.end));

        int minCount = 0;
        for (Meeting meeting : meetings) {
            while (!minHeap.isEmpty() && minHeap.peek().end <= meeting.start) {
                minHeap.poll();
            }
            minHeap.offer(meeting);

           minCount = Math.max(minCount,minHeap.size());
        }
        return minCount;
    }


}

