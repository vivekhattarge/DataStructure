package com.slow.fast;

public class FindHappyNumber {

    public static void main(String[] args) {
        System.out.println("Happy Number : " + isHappyNumber(23));
        System.out.println("Happy Number : " + isHappyNumber(12));
    }

    private static boolean isHappyNumber(int number) {

        int slow = number;
        int fast = number;

        do {
            slow = findSquaredSum(slow); // moves one step
            fast = findSquaredSum(findSquaredSum(fast)); // moves two step
        } while (slow != fast); // cycle is found

        // if cycle is found at 1 then it's a happy number.
        return slow == 1;
    }

    private static int findSquaredSum(int number) {
        int sum = 0;
        while (number > 0){
            int digit = number % 10;
            sum += digit * digit;
            number = number/10;
        }
        return sum;
    }

}
