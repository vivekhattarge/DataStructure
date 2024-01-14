package com.daily.challenges;

import java.util.*;

/*Two strings are considered close if you can attain one from the other using the following operations:

Operation 1: Swap any two existing characters.
For example, abcde -> aecdb
Operation 2: Transform every occurrence of one existing character into another existing character, and do the same with the other character.
For example, aacabb -> bbcbaa (all a's turn into b's, and all b's turn into a's)
You can use the operations on either string as many times as necessary.

Given two strings, word1 and word2, return true if word1 and word2 are close, and false otherwise.



Example 1:

Input: word1 = "abc", word2 = "bca"
Output: true
Explanation: You can attain word2 from word1 in 2 operations.
Apply Operation 1: "abc" -> "acb"
Apply Operation 1: "acb" -> "bca"
Example 2:

Input: word1 = "a", word2 = "aa"
Output: false
Explanation: It is impossible to attain word2 from word1, or vice versa, in any number of operations.
Example 3:

Input: word1 = "cabbba", word2 = "abbccc"
Output: true
Explanation: You can attain word2 from word1 in 3 operations.
Apply Operation 1: "cabbba" -> "caabbb"
Apply Operation 2: "caabbb" -> "baaccc"
Apply Operation 2: "baaccc" -> "abbccc"
*/

public class DetermineIfStringsAreClose {

        public static boolean closeStrings(String word1, String word2) {

            if(word1.length() != word2.length()){
                return false;
            }

            Map<Character,Integer> wordCount1 = new HashMap<>();
            Map<Character,Integer> wordCount2 = new HashMap<>();

            for(int i=0; i<word1.length();i++){
                char letter1 = word1.charAt(i);
                char letter2 = word2.charAt(i);

                wordCount1.merge(letter1,1,Integer::sum);
                wordCount2.merge(letter2,1,Integer::sum);
            }

            if(!wordCount1.keySet().equals(wordCount2.keySet())){
                return false;
            }

            List<Integer> word1countValues = new ArrayList<>(wordCount1.values());
            List<Integer> word2countValues = new ArrayList<>(wordCount2.values());

            Collections.sort(word1countValues);
            Collections.sort(word2countValues);
            return word1countValues.equals(word2countValues);
        }

    public static void main(String[] args) {
            String s1 = "abc";
            String s2 = "cba";
        if(closeStrings(s1,s2)){
            System.out.println("Strings are close");
        }else{
            System.out.println("Strings are not close");
        }
    }
    }


