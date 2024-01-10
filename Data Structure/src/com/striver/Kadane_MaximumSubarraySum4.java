package com.striver;

/*
Problem Statement: Given an integer array arr, find the contiguous subarray (containing at least one number) which
        has the largest sum and return its sum and print the subarray.

        Examples:

        Example 1:

        Input: arr = [-2,1,-3,4,-1,2,1,-5,4]

        Output: 6

        Explanation: [4,-1,2,1] has the largest sum = 6.

        Examples 2:

        Input: arr = [1]

        Output: 1

        Explanation: Array has only one element and which is giving positive sum of 1.
*/


public class Kadane_MaximumSubarraySum4 {

    public static void main(String[] args) {

//        int[] iparray = {-2, 1, -3, 4, -1, 2, 1, -5, 4};
//        int[] iparray = {-2, -1,-4,-9};
//        int[] iparray = {-1,1,2,1};
        int[] iparray = {-2,-1};
//        int[] iparray = {-1};
        int result = getMaximumSubarraySum(iparray);
        System.out.println("Result is  : " + result);
    }
    private static int getMaximumSubarraySum(int[] iparray) {
        int sum = Integer.MIN_VALUE;
        int currentSum = 0;
        for(int num : iparray){
            currentSum += num;
            sum = Math.max(sum,currentSum);

            if(currentSum < 0){
                currentSum = 0;
            }
        }
        return sum;
    }
}
