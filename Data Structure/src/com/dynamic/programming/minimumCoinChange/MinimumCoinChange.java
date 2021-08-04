package com.dynamic.programming.minimumCoinChange;

public class MinimumCoinChange {
    public static void main(String[] args) {
        MinimumCoinChange minimumCoinChange = new MinimumCoinChange();
        int total = 5;
        int[] denominations = {1, 2, 3};
        System.out.println("count of change  : "+minimumCoinChange.countChange(denominations, total));

        denominations = new int[]{3, 5};
        System.out.println("count of change : "+minimumCoinChange.countChange(denominations, 7));
    }

    private int countChange(int[] denominations, int total) {
        int result = countChangeRecursively(denominations,total,0);
        return (result == Integer.MAX_VALUE ? -1 : result);
    }

    private int countChangeRecursively(int[] denominations, int total,int currentIndex) {

        if(total == 0){
            return 0;
        }

        if(denominations.length == 0 || currentIndex >= denominations.length){
            return Integer.MAX_VALUE;
        }

        int count1 = Integer.MAX_VALUE;

        // by including current index element
        if (denominations[currentIndex] <= total) {
            int res = countChangeRecursively(denominations, total - denominations[currentIndex], currentIndex);
            if (res != Integer.MAX_VALUE) {
                count1 = res + 1;
            }
        }
        int count2 = countChangeRecursively(denominations, total, currentIndex + 1);
        return Math.min(count1, count2);
    }
}
