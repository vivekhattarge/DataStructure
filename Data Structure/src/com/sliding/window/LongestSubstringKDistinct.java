package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringKDistinct {

    public static void main(String[] args) {

        System.out.println("Longest Substring length is : " + getLongestSubstringLength("araaci", 2));

    }

    private static int getLongestSubstringLength(String inputString, int noMoreThanCount) {
        int maximumLength = 0;

        int windowStart = 0;
        //Frequency map helps to keep frequency of each character
        Map<Character, Integer> frequencyMap = new HashMap<>();
        for (int windowEnd = 0; inputString.length() > windowEnd; windowEnd++) {
            char leftChar = inputString.charAt(windowEnd);
            frequencyMap.put(leftChar, frequencyMap.getOrDefault(leftChar, 0) + 1);

            // if size of distinct elements become greater than given count then this while will be triggered.
            while (frequencyMap.size() > noMoreThanCount) {
                frequencyMap.put(leftChar, frequencyMap.get(leftChar) - 1);
                if (frequencyMap.get(leftChar) == 0) {
                    frequencyMap.remove(leftChar);
                }
                // will shring window from start by one place.
                windowStart++;
            }
            maximumLength = Math.max(maximumLength, windowEnd - windowStart + 1);
        }
        return maximumLength;
    }


}
