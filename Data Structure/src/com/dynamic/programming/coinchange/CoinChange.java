package com.dynamic.programming.coinchange;

public class CoinChange {

    public static void main(String[] args) {

        CoinChange cc = new CoinChange();
        int[] denominations = {1, 2, 3};
        System.out.println("Coin Denominations ways are : "+cc.countChange(denominations, 5));

    }

    private int countChange(int[] denominations, int total) {

        return countChangeRecursive(denominations,total,0);
    }

    private int countChangeRecursive(int[] denominations, int total, int currentIndex) {

        if(total == 0){
            return 1;
        }
        if(denominations.length == 0 || currentIndex >= denominations.length){
            return 0;
        }
        int sum1=0;

        // by including denomination at currentindex
        if(denominations[currentIndex] <= total){
            sum1 = countChangeRecursive(denominations, total-denominations[currentIndex], currentIndex);
        }

        // by excluding denomination at currentindex
        int sum2 = countChangeRecursive(denominations, total, currentIndex+1);

        return sum1+sum2;
    }


}
