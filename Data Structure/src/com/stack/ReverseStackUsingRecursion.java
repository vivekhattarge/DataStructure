package com.stack;

import java.util.Stack;

public class ReverseStackUsingRecursion {

    static Stack<Integer> integerStack = new Stack<>();

    public static void main(String[] args) {

        integerStack.push(1);
        integerStack.push(2);
        integerStack.push(3);
        integerStack.push(4);

        System.out.println("original stack : " + integerStack);

        reverse();

        System.out.println("reversed stack : " + integerStack);
    }


    private static void reverse() {
        if (!integerStack.isEmpty()) {

            // Holds all elements in function call stack
            int a = integerStack.peek();
            integerStack.pop();
            reverse();

            //insert all elements from function call stack to bottom of original stack
            insertAtBottom(a);
        }

    }

    private static void insertAtBottom(int a) {

        if (integerStack.isEmpty()) {
            integerStack.push(a);
        } else {

            int x = integerStack.peek();
            integerStack.pop();
            insertAtBottom(a);

            //push all elements from function call stack to original stack
            integerStack.push(x);
        }

    }

}
