package com.dynamic.programming.coinchange;

public class CoinChange_TopDown {

    public static void main(String[] args) {
        CoinChange_TopDown cc = new CoinChange_TopDown();
        int[] denominations = {1, 2, 3};
        System.out.println("Coin Denominations ways are : "+cc.countChange(denominations, 5));
    }

    private int countChange(int[] denominations, int total) {
        Integer [][] dp = new Integer[denominations.length][total+1];
       return countCoinChange(dp,denominations,total,0);
    }

    private int countCoinChange(Integer[][] dp, int[] denominations, int total,int currentIndex) {

        if(total == 0){
            return 1;
        }
        if (denominations.length == 0 || currentIndex >= denominations.length) {
            return 0;
        }

        if(dp[currentIndex][total] != null){
            return dp[currentIndex][total];
        }

        int sum1=0;
        if(denominations[currentIndex] <= total){
            sum1 = countCoinChange(dp,denominations,total - denominations[currentIndex],currentIndex);
        }
        int sum2 = countCoinChange(dp,denominations,total,currentIndex+1);

        dp[currentIndex][total] = sum1+sum2;
        return dp[currentIndex][total];
    }

}
