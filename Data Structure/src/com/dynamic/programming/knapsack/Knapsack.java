package com.dynamic.programming.knapsack;

public class Knapsack {
    public static void main(String[] args) {
        Knapsack ks = new Knapsack();

        int[] profits = new int[]{1, 6, 10, 16};
        int[] weights = new int[]{1, 2, 3, 5};
        int knapsackCapacity = 7;
        int maxProfit = ks.solveKnapsack(profits, weights, knapsackCapacity);
        System.out.println("Maximum profit is : " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int knapsackCapacity) {
        Integer[][] dp = new Integer[profits.length][knapsackCapacity+1];
        return solveKnapsackRecursively(dp,profits, weights, knapsackCapacity, 0);
    }

    private int solveKnapsackRecursively(Integer[][] dp,int[] profits, int[] weights, int knapsackCapacity, int currentIndex) {

        if(knapsackCapacity <= 0 ||profits.length <= currentIndex){
            return 0;
        }

        int profit1 = 0;

        if(dp[currentIndex][knapsackCapacity] != null){
            return dp[currentIndex][knapsackCapacity];
        }

        if(weights[currentIndex] <= knapsackCapacity){
            profit1 = profits[currentIndex] + solveKnapsackRecursively(dp,profits,weights, knapsackCapacity - weights[currentIndex],currentIndex+1);
        }

        int profit2 = solveKnapsackRecursively(dp,profits,weights,knapsackCapacity,currentIndex+1);

        dp[currentIndex][knapsackCapacity] = Math.max(profit1,profit2);
        return Math.max(profit1,profit2);
    }
}
