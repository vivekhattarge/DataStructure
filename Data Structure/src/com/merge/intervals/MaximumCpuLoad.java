package com.merge.intervals;

import java.util.*;

class Job{
    public int start;
    public int end;
    public int load;

    public Job(int start, int end, int load) {
        this.start = start;
        this.end = end;
        this.load = load;
    }
}


public class MaximumCpuLoad {

    public static void main(String[] args) {

        List<Job> input = new ArrayList<Job>(Arrays.asList(new Job(1, 4, 3), new Job(2, 5, 4), new Job(7, 9, 6)));
        System.out.println("Maximum CPU load at any time: " + MaximumCpuLoad.findMaxCPULoad(input));

    }

    private static int findMaxCPULoad(List<Job> jobs) {

        Collections.sort(jobs, (a,b) -> Integer.compare(a.start,b.start));

        PriorityQueue<Job> minHeap = new PriorityQueue<>(jobs.size(), (a,b) -> Integer.compare(a.end,b.end));

        int maxCpuLoad =0;
        int currentLoad = 0;
        for(Job job : jobs){

            while (!minHeap.isEmpty() && minHeap.peek().end < job.start){
                currentLoad -= minHeap.peek().load;
                minHeap.poll();
            }
            minHeap.offer(job);
            currentLoad += job.load;
            maxCpuLoad = Math.max(maxCpuLoad, currentLoad);
        }

        return maxCpuLoad;
    }

}
