package com.dynamic.programming.minimumSubsetSumDifference;

public class PartitionSetUsingTabulation {

    public static void main(String[] args) {
        PartitionSetUsingTabulation partitionSet = new PartitionSetUsingTabulation();

       // int [] numbers = {1,2,3,9};
        int [] numbers = {1, 2, 7, 1, 5};
        System.out.println(partitionSet.canPartition(numbers));
    }

    private int canPartition(int[] numbers) {

        int sum = 0;
        for(int number : numbers){
            sum += number;
        }

        int sum1 = sum/2;

        boolean [][] dp = new boolean[numbers.length][sum1+1];

        // populate column - 0
        for(int i=0;i < numbers.length;i++){
            dp[i][0] = true;
        }

        // populate Row 0, here we have only one element in set so value == sum = TRUE
        for(int s=1;s<=sum1;s++){
            dp[0][s] =  s == numbers[0];
        }

        for(int i=1; i< numbers.length;i++){
            for(int s=1; s<=sum1;s++){

                if(dp[i-1][s]){
                    dp[i][s] = true;
                }else if(s >= numbers[i]){
                    dp[i][s] = dp[i-1][s - numbers[i]];
                }

            }
        }
        sum1 = 0;
        // check from end which is the closest sum to sum/2
        for (int i = sum/2; i >= 0; i--) {

            if (dp[numbers.length-1][i]){
                sum1 = i;
                break;
            }

        }

        // sum2 is always greater than or equal to sum1 because we found sum1
        // which is either equal to sum/2 or less than that
        int sum2 = sum-sum1;

        return Math.abs(sum2-sum1);
    }

}
