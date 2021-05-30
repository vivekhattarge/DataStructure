package com.dynamic.programming;

public class KnapsackBottomUp {

    public static void main(String[] args) {
        KnapsackBottomUp ks = new KnapsackBottomUp();
        int[] profits = {1, 6, 10, 16};
        int[] weights = {1, 2, 3, 5};
        int maxProfit = ks.solveKnapsack(profits, weights, 7);
        System.out.println("Total knapsack profit ---> " + maxProfit);
    }

    private int solveKnapsack(int[] profits, int[] weights, int capacity) {

        if (capacity <= 0 || profits.length == 0 || weights.length != profits.length) {
            return 0;
        }

        int n = profits.length;
        int[][] dp = new int[n][capacity + 1];

        //first populate capacity = 0 items, with 0 capacity we will have 0 profit
        for (int i = 0; i < n; i++) {
            dp[i][0] = 0;
        }

        //if we have only one item to put in knapsack, we will take it only if it's weight is not more than capacity
        for (int c = 0; c <= capacity; c++) {
            if (weights[0] <= c) {
                dp[0][c] = profits[0];
            }
        }

        for (int i = 1; i < n; i++) {
            for (int c = 1; c <= capacity; c++) {

                int profit1 = 0, profit2 = 0;

                // including current item's profit, if it's weight is not more than capacity
                if (weights[i] <= c) {
                    profit1 = profits[i] + dp[i - 1][c-weights[i]];
                }

                //excluding an item
                profit2 = dp[i - 1][c];

                // maximum profit will be at the bottom-right corner.
                dp[i][c] = Math.max(profit1, profit2);
            }
        }
        printSelectedItems(dp,profits,weights,capacity);

        return dp[n - 1][capacity];
    }

    private void printSelectedItems(int[][] dp, int[] profits, int[] weights, int capacity) {

        System.out.print("Selected Items : ");

        int totalProfit = dp[weights.length-1][capacity];

        for(int i = weights.length-1;i>0;i--){

            if(dp[i-1][capacity] != totalProfit){
                System.out.print(" "+weights[i]);
                capacity = capacity - weights[i];
                totalProfit = totalProfit - profits[i];
            }

        }

        if(totalProfit != 0){
            System.out.print(" "+weights[0]);
        }
        System.out.println();
    }

}
