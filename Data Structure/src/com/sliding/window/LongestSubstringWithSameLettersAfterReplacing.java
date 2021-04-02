package com.sliding.window;

import java.util.HashMap;
import java.util.Map;

public class LongestSubstringWithSameLettersAfterReplacing {

    public static void main(String[] args) {

        System.out.println("Longest Substring after replacing k characters of string : "+ getLongestSubstringLength("aabccbb",2));
        System.out.println("Longest Substring after replacing k characters of string : "+ getLongestSubstringLength("abbcb",1));
        System.out.println("Longest Substring after replacing k characters of string : "+ getLongestSubstringLength("abccde",1));

    }
    //aabccbb
    private static int getLongestSubstringLength(String inputString, int replacementNumber) {
        int maxLength =0;
        Map<Character,Integer> characterFrequency = new HashMap<>();

        int windowStart =0;
        for (int windowEnd = 0; windowEnd < inputString.length(); windowEnd++) {
            Character rightChar = inputString.charAt(windowEnd);
            characterFrequency.put(rightChar, characterFrequency.getOrDefault(rightChar, 0) + 1);
            int maxCharCount = characterFrequency.get(rightChar);

            // this is windowSize-currentCharacterCount, it should be greater than replacementCount
            if (windowEnd - windowStart + 1 - maxCharCount > replacementNumber) {
                Character leftChar = inputString.charAt(windowStart);
                characterFrequency.put(leftChar,characterFrequency.get(leftChar)-1);
                windowStart++;
            }
            maxLength = Math.max(maxLength,windowEnd-windowStart+1);
        }
        return maxLength;
    }

}
