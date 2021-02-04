package com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class ReverseQueue {

    public static void main(String[] args) {

        Queue<Integer> queue = new LinkedList<>();

        queue.add(10);
        queue.add(20);
        queue.add(30);
        queue.add(40);
        queue.add(50);
        queue.add(60);
        System.out.println("before reverse : "+queue.toString());
        reverseQueue(queue);
        System.out.println("after reverse : "+queue.toString());

    }

    private static void reverseQueue(Queue<Integer> queue) {
        Stack<Integer> tempStack = new Stack<>();
        while (!queue.isEmpty()){
            tempStack.push(queue.poll());
        }
        while (!tempStack.isEmpty()){
            queue.add(tempStack.pop());
        }
    }


}
