package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class SmallestWindowOfContainingPattern {

    public static void main(String[] args) {

        System.out.println("Smallest window containing pattern : " + getSmallestWindow("aabdec", "abc"));
        System.out.println("Smallest window containing pattern : " + getSmallestWindow("abdbca", "abc"));
        System.out.println("Smallest window containing pattern : " + getSmallestWindow("adcad", "abc"));

    }

    private static String getSmallestWindow(String inputString, String patternString) {

        int windowStart = 0;
        int minLength = Integer.MAX_VALUE;
        int matched = 0;
        String smallestWindow = null;
        Map<Character, Integer> frequencyMap = new HashMap<>();

        for (Character patternCharacter : patternString.toCharArray()) {
            frequencyMap.put(patternCharacter, frequencyMap.getOrDefault(patternCharacter, 0) + 1);
        }

        for (int windowEnd = 0; windowEnd < inputString.length(); windowEnd++) {
            char rightChar = inputString.charAt(windowEnd);
            if (frequencyMap.containsKey(rightChar)) {
                frequencyMap.put(rightChar, frequencyMap.get(rightChar) - 1);
                if (frequencyMap.get(rightChar) >= 0) {
                    matched++;
                }
            }

            while (patternString.length() == matched) {
                if (minLength > windowEnd - windowStart + 1) {
                    minLength = Math.min(minLength, windowEnd - windowStart + 1);
                    smallestWindow = inputString.substring(windowStart, windowStart + minLength);
                }

                char leftChar = inputString.charAt(windowStart);
                windowStart += 1;

                if (frequencyMap.containsKey(leftChar)) {
                    if (frequencyMap.get(leftChar) == 0) {
                        matched--;
                    }
                    frequencyMap.put(leftChar, frequencyMap.get(leftChar) + 1);
                }
            }
        }

        return smallestWindow;
    }


}
