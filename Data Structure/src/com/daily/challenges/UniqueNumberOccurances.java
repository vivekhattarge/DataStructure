package com.daily.challenges;

import java.util.*;
import java.util.stream.Collectors;

/*
1207. Unique Number of Occurrences

Given an array of integers arr, return true if the number of occurrences of each value in the array is unique or false otherwise.

Example 1:

Input: arr = [1,2,2,1,1,3]
Output: true
Explanation: The value 1 has 3 occurrences, 2 has 2 and 3 has 1. No two values have the same number of occurrences.
Example 2:

Input: arr = [1,2]
Output: false
Example 3:

Input: arr = [-3,0,1,-3,1,1,1,-3,10,0]
Output: true
 */
public class UniqueNumberOccurances {

        public boolean uniqueOccurrences(int[] arr) {

            Map<Integer, Integer> numerToOccurance = new HashMap<>();

            for(int number : arr){
                numerToOccurance.merge(number,1,Integer::sum);
            }

            List<Integer> values =  (numerToOccurance).values().stream().collect(Collectors.toList());
            Set<Integer> valueSet = new HashSet<>(values);
            return  values.size() == valueSet.size();
        }

    public static void main(String[] args) {
        int [] arr = {1,2,2,1,1,3};
        boolean result = new UniqueNumberOccurances().uniqueOccurrences(arr);
        System.out.println(result);
    }
    }

