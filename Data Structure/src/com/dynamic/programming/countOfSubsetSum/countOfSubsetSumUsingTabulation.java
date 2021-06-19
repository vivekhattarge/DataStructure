package com.dynamic.programming.countOfSubsetSum;

public class countOfSubsetSumUsingTabulation {
    public static void main(String[] args) {
        countOfSubsetSumUsingTabulation countOfSubsetSumUsingTabulation = new countOfSubsetSumUsingTabulation();
        int[] num = {1, 1, 2, 3};
        System.out.println(countOfSubsetSumUsingTabulation.countSubsets(num, 4));
    }

    private int countSubsets(int[] nums, int sum) {

        Integer[][] dp = new Integer[nums.length][sum+1];

        // for first column
        for(int i=0;i<nums.length;i++){
            dp[i][0] = 1;
        }

        // for first row
        for(int s =1 ; s <=sum;s++){
            dp[0][s] = (s==nums[0]) ? 1 : 0;
        }

        // now process for remaining subsets
        for(int i=1; i < nums.length ; i++){

            for(int s=1; s <= sum;s++){
                // by excluding number
                dp[i][s] = dp[i-1][s];

                // by including number
                if(s >= nums[i]){
                    dp[i][s] += dp[i-1][s - nums[i]];
                }
            }

        }


        return dp[nums.length-1][sum];
    }

}
