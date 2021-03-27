package com.miscellaneous;

import java.util.Arrays;

public class FindMinimumSubArraySumCount {

    public static void main(String[] args) {

        int[] inputArray = new int[] {2, 1, 5, 2, 3, 2};
        int subArraySum = 7;

        int  resultCount = getMaxSumSubArray(inputArray,subArraySum);

        System.out.println("input array : "+ Arrays.toString(inputArray));
        System.out.println("Minimum sub-array count :  "+ resultCount);

    }

    private static int getMaxSumSubArray(int[] inputArray, int subArraySum) {
        int minimumCountOfSubArrayElements = Integer.MAX_VALUE;
        int windowStart = 0;
        int sum = 0;
        for (int windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            sum += inputArray[windowEnd];
            while (sum >= subArraySum) {
                minimumCountOfSubArrayElements = Math.min(minimumCountOfSubArrayElements, windowEnd - windowStart + 1);
                sum = sum - inputArray[windowStart];
                windowStart += 1;
            }
        }
        return minimumCountOfSubArrayElements;
    }

}
