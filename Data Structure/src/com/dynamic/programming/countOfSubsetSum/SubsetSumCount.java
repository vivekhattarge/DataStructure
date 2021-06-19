package com.dynamic.programming.countOfSubsetSum;

public class SubsetSumCount {

    public static void main(String[] args) {
        SubsetSumCount ss = new SubsetSumCount();
        int[] num = {1, 1, 2, 3};
        System.out.println(ss.countSubsets(num, 4));
    }

    private int countSubsets(int[] nums, int sum) {
        Integer[][] dp = new Integer[nums.length][sum + 1];
        return countSubsetSumRecursively(dp, nums, sum, 0);
    }

    private int countSubsetSumRecursively(Integer[][] dp, int[] nums, int sum, int currentIndex) {

        //base check
        if (sum == 0) {
            return 1;
        }
        if (nums.length == 0 || nums.length <= currentIndex) {
            return 0;
        }
        if (dp[currentIndex][sum] == null) {

            int sum1 = 0;
            if (sum >= nums[currentIndex]) {
                sum1 = countSubsetSumRecursively(dp, nums, sum - nums[currentIndex], currentIndex + 1);
            }
            int sum2 = countSubsetSumRecursively(dp, nums, sum, currentIndex + 1);

            dp[currentIndex][sum] = sum1 + sum2;
        }
        return dp[currentIndex][sum];
    }

}
