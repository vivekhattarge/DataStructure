package com.dynamic.programming.minimumCoinChange;

public class MinimumCoinChange_TopDown {
    public static void main(String[] args) {
        MinimumCoinChange_TopDown minimumCoinChange = new MinimumCoinChange_TopDown();
        int total = 5;
        int[] denominations = {1, 2, 3};
        System.out.println("count of change  : " + minimumCoinChange.countChange(denominations, total));

        denominations = new int[]{3, 5};
        System.out.println("count of change : "+minimumCoinChange.countChange(denominations, 7));
    }

    private int countChange(int[] denominations, int total) {
        Integer[][] dp = new Integer[denominations.length][total + 1];
        int result = countChangeRecursively(dp, denominations, total, 0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int countChangeRecursively(Integer[][] dp, int[] denominations, int total, int currentIndex) {

        if (total == 0) {
            return 0;
        }

        if (denominations.length == 0 || denominations.length <= currentIndex) {
            return Integer.MAX_VALUE;
        }

        if (dp[currentIndex][total] == null) {

            int count1 = Integer.MAX_VALUE;
            // by including denomination at currentindex
            if (total >= denominations[currentIndex]) {
                int result = countChangeRecursively(dp, denominations, total - denominations[currentIndex], currentIndex);
                if (Integer.MAX_VALUE != result) {
                    count1 = result + 1;
                }
            }
            // by excluding denomination at currentindex
            int count2 = countChangeRecursively(dp, denominations, total, currentIndex + 1);

            dp[currentIndex][total] = Math.min(count1, count2);
        }
        return dp[currentIndex][total];
    }
}
