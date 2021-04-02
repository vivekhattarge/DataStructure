package com.two.pointer;

import java.util.ArrayList;
import java.util.List;

public class PairWithTargetSum {

    public static void main(String[] args) {
        int [] inputArray = new int[]{1,2,3,4,6};
        int targetSum = 6;
        System.out.println("Pair of target sum is : "+getTargetSumPair(inputArray,targetSum));
    }

    private static List<Integer> getTargetSumPair(int[] inputArray, int targetSum) {

        List<Integer> result = new ArrayList<>();

        int startPointer = 0;
        int endPointer = inputArray.length-1;

        while(startPointer <= endPointer){

            int leftNumber = inputArray[startPointer];
            int rightNumber = inputArray[endPointer];
            int sum = leftNumber+rightNumber;
            if(targetSum == sum){
                result.add(leftNumber);
                result.add(rightNumber);
                return result;
            }else if(sum > targetSum){
                endPointer = endPointer-1;
            }else{
                startPointer = startPointer+1;
            }
        }
        return result;
    }

}
