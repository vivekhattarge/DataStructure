package com.dynamic.programming.unboundedKnapsack;

public class Knapsack_TopDown_Memoization {


    public static void main(String[] args) {

        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        int knapsackWeight = 8;
        int maxProfit = getMaxProfitFromKnapsack(profits, weights, knapsackWeight);
        System.out.println("Maximum profit is : " + maxProfit);
    }

    private static int getMaxProfitFromKnapsack(int[] profits, int[] weights, int knapsackWeight) {

        Integer[][] dp = new Integer[profits.length][knapsackWeight + 1];
        return solveKnapsack(dp, profits, weights, knapsackWeight, 0);
    }

    private static int solveKnapsack(Integer[][] dp, int[] profits, int[] weights, int knapsackWeight, int currentIndex) {

        if(profits.length != weights.length || profits.length < 1 || currentIndex >= profits.length || knapsackWeight <= 0){
            return 0;
        }

        if(dp[currentIndex][knapsackWeight] == null){
            int profit1 = 0;
            if(weights[currentIndex] <= knapsackWeight){
                profit1 = profits[currentIndex] + solveKnapsack(dp,profits,weights,knapsackWeight - weights[currentIndex],currentIndex);
            }
            int profit2 =  solveKnapsack(dp,profits,weights,knapsackWeight,currentIndex+1);

            dp[currentIndex][knapsackWeight] = Math.max(profit1,profit2);
        }

        return dp[currentIndex][knapsackWeight];
    }

}
