package com.dynamic.programming.unboundedKnapsack;

public class Knapsack_BottomUp_Memoization {

    public static void main(String[] args) {


        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        int knapsackWeight = 8;
        int maxProfit = getMaxProfitFromKnapsack(profits, weights, knapsackWeight);
        System.out.println("Maximum profit is : " + maxProfit);

    }

    private static int getMaxProfitFromKnapsack(int[] profits, int[] weights, int knapsackWeight) {
        return solveKnapsack(profits, weights, knapsackWeight);
    }

    private static int solveKnapsack(int[] profits, int[] weights, int knapsackWeight) {

        if (profits.length == 0 || profits.length != weights.length || knapsackWeight <= 0) {
            return 0;
        }
        int n = profits.length;
        Integer[][] dp = new Integer[n][knapsackWeight + 1];

        //populate capacity=0 columns
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        //process all subarrays and capacities
        for (int i = 0; i < n; i++) {
            for (int c = 1; c <= knapsackWeight; c++) {
                int profit1 = 0, profit2 = 0;
                //including current element
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i][c - weights[i]];
                }
                //excluding current element and copying element from above cell
                if (i > 0) {
                    profit2 = dp[i - 1][c];
                }
                dp[i][c] = Math.max(profit1,profit2);
            }
        }
        return dp[profits.length-1][knapsackWeight];
    }

}
