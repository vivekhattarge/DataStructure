package com.pattern.two_pointers;

import java.util.Arrays;

public class SumOfThree {
    public static void main(String[] args) {

        int [] nums = {-1,2,1,-4,5,-3};
        //1,2,3,4,5,7,8
        //-4,-3,-1,1,2,5
        int target = -8;
        boolean result = findSumOfThree(nums,target);
        System.out.println("is sum of three present : "+result);
    }

    private static boolean findSumOfThree(int[] nums, int target) {
        Arrays.sort(nums);
        if(nums.length < 2){
            return false;
        }
        int currentPointer=0;
        while(currentPointer < nums.length-2){

        int low = currentPointer+1;
        int high = nums.length-1;

        while(low < high){
            int sum = nums[low] + nums[currentPointer] + nums[high];
            if(sum == target){
                return true;
            }
            if(sum > target){
                high--;
            } else {
                low++;
            }
        }
        currentPointer++;
        }
        return false;
    }
}
