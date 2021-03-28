package com.miscellaneous;

import java.util.*;

public class FindIndicesOfPatternStringAnagram {

    public static void main(String[] args) {
        System.out.println("Indices of string anagram is : "+getStringAnagramIndices("ppqp","pq"));
        System.out.println("Indices of string anagram is : "+getStringAnagramIndices("abbcabc","abc"));
    }

    private static List<Integer> getStringAnagramIndices(String inputString, String patternString) {

        List<Integer> patternIndices = new ArrayList<>();
        Map<Character,Integer> characterFrequency = new HashMap<>();
        for (Character character : patternString.toCharArray()){
            characterFrequency.put(character, characterFrequency.getOrDefault(character, 0) + 1);
        }
        int windowStart=0;
        int matched=0;
        for(int windowEnd = 0; windowEnd < inputString.length();windowEnd++){
            char rightChar = inputString.charAt(windowEnd);
            if(characterFrequency.containsKey(rightChar)){
                characterFrequency.put(rightChar, characterFrequency.get(rightChar) - 1);
                if(characterFrequency.get(rightChar) == 0){
                    matched++;
                }
            }
            if(matched == characterFrequency.size()){
                patternIndices.add(windowStart);
            }
            if(windowEnd >= patternString.length()-1){
                char leftChar = inputString.charAt(windowStart);
                windowStart += 1;
                if(characterFrequency.containsKey(leftChar)){
                    if(characterFrequency.get(leftChar) == 0){
                        matched--;
                    }
                    characterFrequency.put(leftChar,characterFrequency.get(leftChar)+1);
                }
            }
        }
        return patternIndices;
    }

}
