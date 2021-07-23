package com.dynamic.programming.coinchange;

public class CoinChange_BottomUp {

    public static void main(String[] args) {
        CoinChange_BottomUp cc = new CoinChange_BottomUp();
        int[] denominations = {1, 2, 3};
        System.out.println("Coin Denominations ways are : "+cc.countChange(denominations, 5));
    }

    private int countChange(int[] denominations, int total) {

        int n = denominations.length;
        int[][] dp = new int[n][total+1];

        // for total=0 column populate all rows as 1
        for(int i=0;i<n;i++){
            dp[i][0] = 1;
        }

        // process all sub arrays for all capacities
        for(int i=0;i<n;i++){
            for(int t=0; t<=total;t++){

                if(i>0){
                    dp[i][t] = dp[i-1][t];
                }
                if(t >= denominations[i]){
                    dp[i][t] += dp[i][t-denominations[i]];
                }

            }

        }

        // total combinations will be at bottom right corner
        return dp[n-1][total];
    }

}
