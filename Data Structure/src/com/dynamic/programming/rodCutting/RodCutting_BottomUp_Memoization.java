package com.dynamic.programming.rodCutting;

public class RodCutting_BottomUp_Memoization {

    public static void main(String[] args) {

        RodCutting_BottomUp_Memoization rodCutting = new RodCutting_BottomUp_Memoization();

        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};

        System.out.println("Maximum profits is : " + rodCutting.getMaximumProfit(lengths, prices, 5));

    }

    private int getMaximumProfit(int[] lengths, int[] prices, int rodLength) {

        if(lengths.length == 0 || lengths.length != prices.length || rodLength <=0){
            return 0;
        }

        int [][] dp = new int[lengths.length][rodLength+1];

        for (int i = 0; i < lengths.length; i++) {

            for (int len = 1; len <= rodLength; len++) {

                int profit1 = 0,profit2 = 0;

                // by excluding current element
                if(i > 0){
                    profit1 = dp[i-1][len];
                }

                // by including current price
                if(len >= lengths[i]){
                    profit2 = prices[i] + dp[i][len-lengths[i]];
                }
                dp[i][len] = Math.max(profit1,profit2);
            }

        }
        printSelectedLengths(dp,lengths,prices,rodLength);
        return dp[lengths.length-1][rodLength];
    }

    private void printSelectedLengths(int[][] dp, int[] lengths, int[] prices, int rodLength) {

        System.out.print("Selected items are : ");

        int totalProfit = dp[lengths.length-1][rodLength];

        for(int i = lengths.length-1; i>0;i--){

            while(dp[i-1][rodLength] != totalProfit){
                System.out.print(" "+lengths[i]);
                rodLength = rodLength - lengths[i];
                totalProfit = totalProfit - prices[i];
            }

        }
        if(totalProfit != 0){
            System.out.print(" "+lengths[0]);
        }
        System.out.println();
    }

}
