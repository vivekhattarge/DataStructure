package com.misc;

// A beautiful number is a number whose individual number squares' sum becomes 1
/*
 *   e.g.  31 = 3^2 + 1^2 = 9+1 =10
 *         1^2 + 0^2 = 1+0 = 1 ..... Yay it's beautiful number
 *
 *          32 = 3^2 + 2^2 = 9+4 =13
 *         1^2 + 3^2 = 1+9 = 10
 *         1^2 + 0^2 = 1+0 = 1  ..... Yay it's beautiful number
 * */

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class FindBeautifulNumberSumFromRange {

    public static void main(String[] args) {

        int left = 1;
        int right = 100;
        List<Integer> beautifulNumbers = new ArrayList<>();
        int sum = getSumOfBeautifulNumbers(left, right,beautifulNumbers);
        System.out.println("Sum is : " + sum);
        System.out.println("Beautiful Numbers : "+beautifulNumbers);
    }

    private static int getSumOfBeautifulNumbers(int left, int right,List<Integer> beautifulNumbers) {
        int sum = 0;
        for (int num = left; num <= right; num++) {

            int number = num;
            boolean isNumberBeautiful = isBeautifulNumber(number);

            if (isNumberBeautiful) {
                beautifulNumbers.add(num);
                sum = sum + num;
            }

        }
        return sum;
    }

    private static boolean isBeautifulNumber(int number) {

        Set<Integer> visitedNumbers = new HashSet<>();

        while (true) {
            int sumOfSquares = getSumOfSquares(number);

            if (sumOfSquares == 1) {
                return true;
            }

            number = sumOfSquares;

            if (visitedNumbers.contains(number)) {
                return false;
            }

            // mark number as visited
            visitedNumbers.add(number);
        }
    }

    private static int getSumOfSquares(int number) {
        int sum = 0;
        while (number > 0) {
            int remainder = number % 10;
            sum = sum + (remainder * remainder);
            number = number / 10;
        }
        return sum;
    }


}
