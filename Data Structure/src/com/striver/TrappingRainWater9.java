package com.striver;

/*
Trapping Rainwater
        Problem Statement: Given an array of non-negative integers representation elevation of ground. Your task is to find the water that can be trapped after rain.

        Examples:

        Example 1:

        Input: height= [0,1,0,2,1,0,1,3,2,1,2,1]

        Output: 6

        Explanation: As seen from the diagram 1+1+2+1+1=6 unit of water can be trapped



        Example 2:

        Input:  [4,2,0,3,2,5]

        Output:9
*/

public class TrappingRainWater9 {

    public static void main(String args[]) {
        int arr[] = {0,1,0,2,1,0,1,3,2,1,2,1};
        System.out.println("The duplicate element is " + trap(arr));
    }

    private static int trap(int[] heights) {

        int left = 0;
        int right = heights.length - 1;
        int trappedWater = 0;
        int leftMax = 0;
        int rightMax = 0;
        while (left <= right) {
            if (heights[left] <= heights[right]) {
                 if (heights[left] >= leftMax) {
                    leftMax = heights[left];
                } else {
                    trappedWater += leftMax - heights[left];
                }
                left++;
            } else {
                if (heights[right] >= rightMax) {
                    rightMax = heights[right];
                } else {
                    trappedWater += rightMax - heights[right];
                }
                right--;
            }
        }
        return trappedWater;
    }

}
