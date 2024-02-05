package com.daily.challenges;


/*
* 387. First Unique Character in a String
Solved
Easy
Topics
Companies
Given a string s, find the first non-repeating character in it and return its index. If it does not exist, return -1.


Example 1:

Input: s = "leetcode"
Output: 0
Example 2:

Input: s = "loveleetcode"
Output: 2
Example 3:

Input: s = "aabb"
Output: -1


Constraints:

1 <= s.length <= 105
s consists of only lowercase English letters
* */

class FirstUniqueChar {
    public int firstUniqChar(String s) {
        
       int [] arr = new int[26];

       for(char letter : s.toCharArray()){
           int value = arr[letter - 'a'] + 1;
           arr[letter-'a'] = value;
       }
       int i = 0;
       for(char letter : s.toCharArray()){
           if(arr[letter - 'a'] == 1){
               return i;
           }
           i++;
       }
        return -1;
    }

    public static void main(String[] args) {
    String s = "dddccdbba";

        System.out.println(new FirstUniqueChar().firstUniqChar(s));
    }
}