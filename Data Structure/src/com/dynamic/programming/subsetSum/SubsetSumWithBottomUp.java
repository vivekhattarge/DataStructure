package com.dynamic.programming.subsetSum;

public class SubsetSumWithBottomUp {

    public static void main(String[] args) {

        int [] nums = {1,2,5,7};
        int sum = 8;

        System.out.println("Can we have subset with given sum : "+canHaveSubsetWithGivenSum(nums,sum));

    }

    private static boolean canHaveSubsetWithGivenSum(int[] nums,int sum) {


        boolean [][] dp = new boolean[nums.length][sum+1];

        // for first column (and all rows)
        for(int i=0; i < nums.length; i++){
            dp[i][0] = true;
        }

        // when we have only one element in set then, then sum== value of number  then is can be formed as subset, so true else false
        for(int s=1; s <= sum; s++){
            dp[0][s] = nums[0] == s;
        }

        for(int i=1;i< nums.length;i++){
            for(int s = 1; s <= sum; s++){
                if(dp[i-1][s]){
                    dp[i][s] = dp[i-1][s];
                }else if(s >= nums[i]){
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }

        return dp[nums.length-1][sum];
    }

}
