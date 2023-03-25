package com.striver;

public class TrappingRainWater {

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
