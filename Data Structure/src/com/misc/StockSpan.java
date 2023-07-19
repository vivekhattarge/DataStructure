package com.misc;

import java.util.Arrays;
import java.util.Stack;

public class StockSpan {


/*
    The stock span problem is a financial problem where we have a series of N daily price quotes for a stock and we need to calculate the span of the stock’s price for all N days. The span Si of the stock’s price on a given day i is defined as the maximum number of consecutive days just before the given day, for which the price of the stock on the current day is less than its price on the given day.

            Examples:

    Input: N = 7, price[] = [100 80 60 70 60 75 85]
    Output: 1 1 1 2 1 4 6
    Explanation: Traversing the given input span for 100 will be 1, 80 is smaller than 100 so the span is 1, 60 is smaller than 80 so the span is 1, 70 is greater than 60 so the span is 2 and so on. Hence the output will be 1 1 1 2 1 4 6.

    Input: N = 6, price[] = [10 4 5 90 120 80]
    Output:1 1 2 4 5 1
    Explanation: Traversing the given input span for 10 will be 1, 4 is smaller than 10 so the span will be 1, 5 is greater than 4 so the span will be 2 and so on. Hence, the output will be 1 1 2 4 5 1.
*/

    public static void main(String[] args) {

        int price[] = { 10, 4, 5, 90, 120, 80 };
        int n = price.length;
        int S[] = new int[n];

        // Fill the span values in array S[]
        calculateSpan(price, n, S);

        // print the calculated span values
        printArray(S);

    }

    private static void calculateSpan(int[] price, int n, int[] stockSpan) {

        Stack<Integer> stack = new Stack<>();
        stack.push(0);

        stockSpan[0] = 1;

        for(int i=1; i<n;i++){

            while (!stack.empty() && price[stack.peek()] <= price[i]){
                stack.pop();
            }

            stockSpan[i] = stack.isEmpty() ? i+1 : i-stack.peek();

            stack.push(i);
        }
    }


    static void printArray(int arr[])
    {
        System.out.print(Arrays.toString(arr));
    }

}
