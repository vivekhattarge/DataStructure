package com.blind75;

public class ProductOfArrayExceptSelf {

    public static void main(String[] args) {

        int [] nums = {1,2,3,4};
        int [] result = productExceptSelf(nums);
        for(int num : result){
            System.out.print(num + " ");
        }
    }

    public static int[] productExceptSelf(int[] nums) {

        int []result = new int[nums.length];

        result[0] = 1;

        //adding product of left elements
        for(int i=1; i<nums.length;i++){

            result[i] = result[i-1] * nums[i-1];

        }

        //adding product of right elements
        int rightProducElement =1;
        for(int i = nums.length-2; i >= 0; i--){

            rightProducElement = rightProducElement * nums[i+1];
            result[i] = rightProducElement * result[i];


        }


    return result;

    }

}
