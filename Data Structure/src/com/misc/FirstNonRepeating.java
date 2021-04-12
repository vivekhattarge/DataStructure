package com.misc;

import java.util.*;

class FirstNonRepeating {

    public static void main(String[] args) {

        System.out.println("first non repeating : " + firstNonRepeatingCharIgnoreCase("sTreSS"));
    }


    public static String firstNonRepeatingLetter(String str) {

        Map<Character, Integer> characterCount = new LinkedHashMap<>();

        for (Character c : str.toCharArray()) {
            characterCount.put(Character.toLowerCase(c), characterCount.containsKey(Character.toLowerCase(c)) ? Character.toLowerCase(c) + 1 : 1);
        }

        for (Map.Entry<Character, Integer> entry : characterCount.entrySet()) {

            if (entry.getValue() == 1) {
                return "" + entry.getKey();
            }
        }
        return "";
    }

      public static char firstNonRepeatingCharIgnoreCase(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonRepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char letter = Character.toLowerCase(word.charAt(i));
            if (repeating.contains(letter)) {
                continue;
            }
            if (nonRepeating.contains(letter)) {
                nonRepeating.remove((Character)letter);
                repeating.add(letter);
            } else {
                nonRepeating.add(letter);
            }
        }
        return nonRepeating.get(0);
    }


}