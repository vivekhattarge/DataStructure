package com.queue;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class QueueUsing2Stacks {



    public static void main(String[] args) {
        Stack<Integer> stack1 = new Stack<>();
        Stack<Integer> stack2 = new Stack<>();

        stackEnque(stack1,1);
        stackEnque(stack1,2);
        stackEnque(stack1,3);

        System.out.println("before : "+stack1);
        stackDeque(stack1,stack2);
        System.out.println("after : "+stack1);

    }

    private static void stackDeque(Stack<Integer> stack1, Stack<Integer> stack2) {
        while(!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }

        while (!stack2.isEmpty()){
            stack1.push(stack2.pop());
        }
    }

    private static void stackEnque(Stack<Integer> stack1, int value) {
        stack1.push(value);
    }


}
