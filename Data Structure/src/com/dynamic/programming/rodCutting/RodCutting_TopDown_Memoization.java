package com.dynamic.programming.rodCutting;

public class RodCutting_TopDown_Memoization {

    public static void main(String[] args) {
        RodCutting_TopDown_Memoization rodCutting = new RodCutting_TopDown_Memoization();

        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};

        System.out.println("Maximum profits is : " + rodCutting.getMaximumProfit(lengths, prices, 5));

    }

    private int getMaximumProfit(int[] lengths, int[] prices, int rodLength) {
        Integer[][] dp = new Integer[lengths.length][rodLength + 1];
        return getMaxProfitRecursively(dp, lengths, prices, rodLength, 0);
    }

    private int getMaxProfitRecursively(Integer[][] dp, int[] lengths, int[] prices, int rodLength, int currentIndex) {

        if (lengths.length == 0 || lengths.length != prices.length ||
                currentIndex >= lengths.length || rodLength <= 0) {
            return 0;
        }

        if (dp[currentIndex][rodLength] == null) {
            int profit1 = 0;
            if (rodLength >= lengths[currentIndex]) {
                profit1 = prices[currentIndex] + getMaxProfitRecursively(dp, lengths, prices, rodLength - lengths[currentIndex], currentIndex);
            }
            int profit2 = getMaxProfitRecursively(dp, lengths, prices, rodLength, currentIndex + 1);
            dp[currentIndex][rodLength] = Math.max(profit1, profit2);
        }

        return dp[currentIndex][rodLength];
    }


}
