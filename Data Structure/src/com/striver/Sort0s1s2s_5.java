package com.striver;

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
