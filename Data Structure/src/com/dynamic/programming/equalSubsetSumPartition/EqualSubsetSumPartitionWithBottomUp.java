package com.dynamic.programming.equalSubsetSumPartition;

public class EqualSubsetSumPartitionWithBottomUp {

    public static void main(String[] args) {

        EqualSubsetSumPartitionWithBottomUp es = new EqualSubsetSumPartitionWithBottomUp();
        int[] nums = {1, 2, 3, 4};

        System.out.println("Can Partition : "+es.canPartition(nums));
    }

    private boolean canPartition(int[] nums) {

        int sum = 0;
        for(int n : nums){
            sum += n;
        }

        // if sum is odd
        if(sum % 2 != 0){
            return false;
        }

        // ROW -> elements
        // COLUMN -> sum (which is sum/2 here) and +1 is to start sum from 0

        //                 0,1,2,3,4,5
        //{1}              T
        //{1,2}            T
        //{1,2,3}          T
        //{1,2,3,4}        T

        sum = sum / 2;
        Boolean[][] dp = new Boolean[nums.length][sum + 1];
        // populate sum=0 column, because we can  have sum =0 by not including any element
        for(int i=0; i< nums.length;i++){
            dp[i][0] = true;
        }

        // for first row
        // when we have only one element then sum== value of number  then is can be formed as subset
        for(int s=1;s<= sum; s++){
            dp[0][s] = nums[0] == s;
        }
        // process all subsets for all sums
        for(int i=1;i< nums.length;i++){
            for(int s=1; s <= sum;s++){
                if(dp[i-1][s]){
                    // excludes new Value
                    dp[i][s] = dp[i-1][s];
                }else if(s >= nums[i]){
                    //check in above row, by including value means at s-nums[i] index
                    dp[i][s] = dp[i-1][s-nums[i]];
                }
            }
        }
        return dp[nums.length-1][sum];
    }

}
