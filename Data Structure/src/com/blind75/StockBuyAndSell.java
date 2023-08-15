package com.blind75;

public class StockBuyAndSell {

    public static void main(String[] args) {

        int [] prices = {7,1,5,3,6,4};
        int maximumProfit = getMaxProfit(prices);

        System.out.println("Maximum profit is : " +maximumProfit);

    }

    private static int getMaxProfit(int[] prices) {
        int minValue = Integer.MAX_VALUE;
        int maxProfit = 0;

        for(int price : prices){

            minValue = Integer.min(minValue,price);
            maxProfit = Integer.max(maxProfit, price - minValue );

        }
            return maxProfit;
    }

}
