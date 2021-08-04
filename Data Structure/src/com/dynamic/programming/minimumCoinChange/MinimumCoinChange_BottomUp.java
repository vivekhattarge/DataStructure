package com.dynamic.programming.minimumCoinChange;

public class MinimumCoinChange_BottomUp {

    public static void main(String[] args) {

        MinimumCoinChange_BottomUp minimumCoinChange = new MinimumCoinChange_BottomUp();
        int total = 5;
        int[] denominations = {1, 2, 3};
        System.out.println("count of change  : " + minimumCoinChange.countChange(denominations, total));

        denominations = new int[]{3, 5};
        System.out.println("count of change : "+minimumCoinChange.countChange(denominations, 7));

    }

    private int countChange(int[] denominations, int total) {

        if (denominations.length == 0) {
            return -1;
        }

        int[][] dp = new int[denominations.length][total + 1];

        for (int i = 0; i < denominations.length; i++) {
            for (int j = 0; j <= total; j++) {
                dp[i][j] = Integer.MAX_VALUE;
            }
        }

        // for total=0, we don't need any coin
        for (int i = 0; i < denominations.length; i++) {
            dp[i][0] = 0;
        }

        for (int i = 0; i < denominations.length; i++) {

            for (int j = 1; j <= total; j++) {

                // by excluding element
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                }

                if (denominations[i] <= j) {

                    // as we have Integer.MAX_VALUE at all cells,
                    // this condition will help not to get min value of Math.min(Integer.MAX_VALUE, Integer.MAX_VALUE + 1) below
                    if (dp[i][j - denominations[i]] != Integer.MAX_VALUE) {
                        dp[i][j] = Math.min(dp[i][j], dp[i][j - denominations[i]] + 1);
                    }
                }

            }

        }

        return (dp[denominations.length - 1][total] == Integer.MAX_VALUE ? -1 : dp[denominations.length - 1][total]);
    }

}
