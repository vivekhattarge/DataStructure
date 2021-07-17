package com.dynamic.programming.unboundedKnapsack;

public class Knapsack {

    public static void main(String[] args) {

        int[] profits = {15, 50, 60, 90};
        int[] weights = {1, 3, 4, 5};
        int knapsackWeight = 8;
        int maxProfit = getMaxProfitFromKnapsack(profits, weights, knapsackWeight);
        System.out.println("Maximum profit is : " + maxProfit);
    }

    private static int getMaxProfitFromKnapsack(int[] profits, int[] weights, int knapsackWeight) {
        return solveKnapsack(profits, weights, knapsackWeight, 0);
    }

    private static int solveKnapsack(int[] profits, int[] weights, int knapsackWeight, int currentIndex) {

        if (profits.length < 1 || knapsackWeight <= 0 || profits.length != weights.length || currentIndex >= profits.length) {
            return 0;
        }

        int profit1 = 0;

        // add current index of profits to knapsack
        if(knapsackWeight >= weights[currentIndex]){
            profit1 = profits[currentIndex] + solveKnapsack(profits,weights,knapsackWeight - weights[currentIndex],currentIndex);
        }

        //don't  add current index of profits to knapsack
        int profit2 = solveKnapsack(profits,weights,knapsackWeight,currentIndex+1);

        return Math.max(profit1,profit2);
    }


}
