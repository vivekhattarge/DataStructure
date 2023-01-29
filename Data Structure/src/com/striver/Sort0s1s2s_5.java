package com.striver;

/*
Sort an array of 0s, 1s and 2s
        Problem Statement: Given an array consisting of only 0s, 1s and 2s. Write a program to in-place sort the array without using inbuilt sort functions. ( Expected: Single pass-O(N) and constant space)

        Example 1:

        Input: nums = [2,0,2,1,1,0]
        Output: [0,0,1,1,2,2]

        Input: nums = [2,0,1]
        Output: [0,1,2]

        Input: nums = [0]
        Input: nums = [0]
*/

public class Sort0s1s2s_5 {
    public static void main(String[] args) {
      //  int [] nums = {2,0,2,1,1,0};
        int [] nums = {2,1,0};
        sortArray(nums);
        for(int num : nums){
            System.out.print(" "+num);
        }
    }

    private static void sortArray(int[] nums) {
        int low = 0;
        int high = nums.length-1;
        int i=0;

        while (i<high){

            if(nums[i] == 0){
                swap(nums,low,i);
                i++;
                low++;
            }else if(nums[i] == 1){
                i++;
            }else{
                swap(nums,i,high);
                high--;
            }
        }

    }

    private static void swap(int [] nums,int first,int second){

        int temp = nums[first];
        nums[first] = nums[second];
        nums[second] = temp;

    }

}
