package com.queue;

import java.util.LinkedList;
import java.util.Queue;

public class ReverseQueueUsingRecursion {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);

        System.out.println("before queue : "+queue);
       Queue<Integer> reversedQueue = reverseQueue(queue);
        System.out.println("after queue : "+reversedQueue);
    }

    private static Queue<Integer> reverseQueue(Queue<Integer> queue) {

        if(queue.isEmpty()){
            return  queue;
        }

        int data = queue.poll();
        Queue<Integer> returnedQueue = reverseQueue(queue);
        returnedQueue.add(data);
        return queue;
    }

}
