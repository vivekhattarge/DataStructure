package com.pattern.two_pointers;

import java.util.Arrays;

public class ReverseWordsInSentence {
    public static void main(String[] args) {
        String sentence = "a   string   with   multiple     spaces";
        String result = reversedSentence(sentence);
        System.out.println(result);
    }

    private static String reversedSentence(String sentence) {

        sentence = sentence.replaceAll("\\s+"," ");

        String [] words = sentence.split(" ");

        int start = 0;
        int end = words.length-1;
        while(start < end){
            String temp = words[start];
            words[start] = words[end];
            words[end] = temp;
            start++;
            end--;
        }
        StringBuilder sb = new StringBuilder();
        Arrays.stream(words).forEach(word -> {
            sb.append(word).append(" ");
        });
       return sb.toString();
    }
}
