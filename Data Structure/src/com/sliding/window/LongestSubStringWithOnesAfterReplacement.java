package com.sliding.window;

public class LongestSubStringWithOnesAfterReplacement {

    public static void main(String[] args) {

        int[] inputArray = new int[]{0, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1};

        System.out.println("Longest substring count after replacing 0's is : " + getLongestSubstringLength(inputArray, 2));

    }

    private static int getLongestSubstringLength(int[] inputArray, int replacementCount) {

        int maxCount = 0;

        int windowStart = 0;
        int onesCount = 0;
        for (int windowEnd = 0; windowEnd < inputArray.length; windowEnd++) {
            if (1 == inputArray[windowEnd]) {
                onesCount += 1;
            }
            // we check whether window has more zeros than replacementCount
            if (windowEnd - windowStart + 1 - onesCount > replacementCount) {
                if (inputArray[windowStart] == 1) {
                    onesCount -= 1;
                }
                windowStart += 1;
            }
            maxCount = Math.max(maxCount, windowEnd - windowStart + 1);
        }

        return maxCount;
    }

}
