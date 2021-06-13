package com.dynamic.programming.equalSubsetSumPartition;

public class EqualSubsetSumPartitionWithMemoization {

    public static void main(String[] args) {

        EqualSubsetSumPartitionWithMemoization es = new EqualSubsetSumPartitionWithMemoization();
        int[] nums = {1, 2, 3, 4};
        System.out.println("Can Partition : "+es.canPartition(nums));
    }

    private boolean canPartition(int[] nums) {
        int sum = 0;
        for(int num : nums){
            sum += num;
        }
        if(sum % 2 != 0){
            return false;
        }
        Boolean [][] dp = new Boolean [nums.length][sum / 2 + 1];
        return canPartitionRecursive(dp, nums,sum/2,0);
    }

    private boolean canPartitionRecursive(Boolean [][] dp, int[] nums, int sum, int currentIndex) {

        // base check
        if(sum == 0){
            return true;
        }

        if(nums.length == 0 || currentIndex >= nums.length){
            return false;
        }

        // if we have not processed similar problem
        if(dp[currentIndex][sum] == null){
            // if number at current index is greater than sum then we shouldn't process it
            if(nums[currentIndex] <= sum){

                if(canPartitionRecursive(dp,nums,sum - nums[currentIndex],currentIndex+1)){
                    dp[currentIndex][sum] = true;
                    return true;
                }
            }

            dp[currentIndex][sum] = canPartitionRecursive(dp,nums,sum,currentIndex+1);

        }

        return dp[currentIndex][sum];
    }

}
