package com.miscellaneous;

import java.util.HashMap;
import java.util.Map;

public class CheckWhetherStringContainsPermutationsOfPattern {

    public static void main(String[] args) {

        System.out.println("Does String contains permutation of pattern : "+findPermutation("oidbcaf","abc"));
        System.out.println("Does String contains permutation of pattern : "+findPermutation("odicf","dc"));
        System.out.println("Does String contains permutation of pattern : "+findPermutation("bcdxabcdy","bcdyabcdx"));
        System.out.println("Does String contains permutation of pattern : "+findPermutation("aaacb","abc"));

    }

    private static boolean findPermutation(String inputString, String patternString) {
        Map<Character,Integer> characterFrequency = new HashMap<>();
        for(Character character : patternString.toCharArray()){
            characterFrequency.put(character, characterFrequency.getOrDefault(character,0)+1);
        }

        int windowStart = 0;
        int matched = 0;
        for(int windowEnd=0;windowEnd < inputString.length();windowEnd++){

            Character rightChar = inputString.charAt(windowEnd);
            if(characterFrequency.containsKey(rightChar)){
                characterFrequency.put(rightChar,characterFrequency.get(rightChar)-1);
                if(characterFrequency.get(rightChar) == 0){
                    matched++;
                }
            }

            if(characterFrequency.size() == matched){
                return true;
            }

            if(windowEnd > patternString.length()-1){
                windowStart += 1;
                Character leftChar = inputString.charAt(windowStart);
                if (characterFrequency.containsKey(leftChar)) {
                    if (0 == characterFrequency.get(leftChar)) {
                        matched -= 1;
                    }
                    characterFrequency.put(leftChar, characterFrequency.get(leftChar) + 1);
                }
            }
        }
        return false;
    }

}
