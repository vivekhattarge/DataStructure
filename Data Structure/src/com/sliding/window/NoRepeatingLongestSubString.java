package com.sliding.window;

import java.util.HashSet;
import java.util.Set;

public class NoRepeatingLongestSubString {

    public static void main(String[] args) {

        System.out.println("Longest non repeating substring count is : "+ getLongestNonRepeatingSubstringCount("aabccbb"));

    }
//aabccbb
    private static int getLongestNonRepeatingSubstringCount(String inputString) {
        int windowStart= 0;
        int maxCount=0;
        Set<Character> uniqueCharacters = new HashSet<>();
        for(int windowEnd=0; windowEnd < inputString.length();windowEnd++){

            char leftChar = inputString.charAt(windowEnd);
            if (uniqueCharacters.contains(leftChar)) {
                maxCount = Math.max(maxCount, (windowEnd-1) - windowStart + 1);
                windowStart = windowEnd;
                uniqueCharacters.clear();
            } else {
                uniqueCharacters.add(leftChar);
            }

        }

        return maxCount;
    }
}
