package com.dynamic.programming.minimumSubsetSumDifference;

public class PartitionSet {

    public static void main(String[] args) {
        PartitionSet partitionSet = new PartitionSet();
        //int [] num = {1,2,7,1,5};
        int [] num = {1,2,3,9};
        System.out.println(partitionSet.canPartition(num));
    }

    private int canPartition(int[] num) {
        int sum =0;
        for(int number : num){
            sum += number;
        }
        Integer [][] dp = new Integer[num.length][sum];
        return this.canPartitionRecursive(dp,num,0,0,0);
    }

    private int canPartitionRecursive(Integer [][] dp,int[] num, int currentIndex, int sum1, int sum2) {

        //base check
        if(currentIndex == num.length){
            return Math.abs(sum1-sum2);
        }

        if(dp[currentIndex][sum1] == null){

        // recursive call after including the number at currentIndex in sum1
        int diff1 = canPartitionRecursive(dp,num,currentIndex+1,sum1+num[currentIndex],sum2);


        // recursive call after including the number at currentIndex in sum2
        int diff2 = canPartitionRecursive(dp,num,currentIndex+1,sum1,sum2+num[currentIndex]);


            dp[currentIndex][sum1] = Math.min(diff1,diff2);
        }
        return dp[currentIndex][sum1];
    }
}
