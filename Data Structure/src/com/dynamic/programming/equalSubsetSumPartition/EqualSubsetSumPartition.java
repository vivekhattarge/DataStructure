package com.dynamic.programming.equalSubsetSumPartition;

public class EqualSubsetSumPartition {
    public static void main(String[] args) {
        EqualSubsetSumPartition ps = new EqualSubsetSumPartition();
        int[] num = {1, 2, 3, 4};
        System.out.println("Can Partition : "+ps.canPartition(num));
    }

    private boolean canPartition(int[] num) {
        int totalSum = 0;
        for(int number : num){
            totalSum += number;
        }
        if (num.length == 0 || totalSum % 2 != 0) {
            return false;
        }
        return canPartitionRecursively(num,totalSum/2,0);
    }

    private boolean canPartitionRecursively(int[] num, int sum, int currentIndex) {

        if(sum == 0){
            return true;
        }

        if(num.length == 0 || currentIndex >= num.length){
            return false;
        }

        // choose number at current index
        // if number is greater than current index's number then we shouldn't process it
        if(num[currentIndex] <= sum){
            if(canPartitionRecursively(num,sum-num[currentIndex],currentIndex+1)){
                return true;
            }
        }

        // call recursively after skipping number at current index
        return canPartitionRecursively(num,sum,currentIndex+1);
    }

}
