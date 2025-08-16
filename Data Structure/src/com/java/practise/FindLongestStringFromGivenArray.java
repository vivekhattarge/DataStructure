package com.java.practise;

import java.util.Arrays;
import java.util.function.Function;
import java.util.stream.Collectors;

public class FindLongestStringFromGivenArray {
    public static void main(String[] args) {
        String [] strs = {"I","Love","java","programming","much"};

        System.out.println("Longest String : "+Arrays.stream(strs).reduce((word1,word2) -> word1.length()>word2.length() ? word1 : word2).get());
    }
}
