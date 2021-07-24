package com.dynamic.programming.rodCutting;

public class RodCutting {

    public static void main(String[] args) {

        RodCutting rodCutting = new RodCutting();

        int[] lengths = {1, 2, 3, 4, 5};
        int[] prices = {2, 6, 7, 10, 13};

        System.out.println("Maximum profits is : " + rodCutting.getMaximumProfit(lengths, prices, 5));

    }

    private int getMaximumProfit(int[] lengths, int[] prices, int rodLength) {
        return getMaxProfitRecursively(lengths, prices, rodLength, 0);
    }

    private int getMaxProfitRecursively(int[] lengths, int[] prices, int rodLength, int currentIndex) {

        if (lengths.length == 0 || lengths.length != prices.length ||
                currentIndex >= lengths.length || rodLength == 0) {
            return 0;
        }

        int profit1 = 0;
        if (rodLength >= lengths[currentIndex]) {
            // profit including price at current index
            profit1 = prices[currentIndex] + getMaxProfitRecursively(lengths, prices, rodLength - lengths[currentIndex], currentIndex);
        }

        int profit2 = getMaxProfitRecursively(lengths, prices, rodLength, currentIndex + 1);
        return Math.max(profit1, profit2);
    }

}
