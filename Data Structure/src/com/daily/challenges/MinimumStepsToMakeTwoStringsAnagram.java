package com.daily.challenges;

public class MinimumStepsToMakeTwoStringsAnagram {
        public int minSteps(String s, String t) {

            int []count = new int[26];

            for(int i=0; i<s.length();i++){
                count[s.charAt(i) - 'a']++;
                count[t.charAt(i) - 'a']--;
            }

            int ans = 0;
            for(int i=0; i < 26; i++){
                ans += Math.max(0,count[i]);
            }

            return ans;
        }

    public static void main(String[] args) {
        String s = "bab";
        String t = "aba";

        int result = new MinimumStepsToMakeTwoStringsAnagram().minSteps(s,t);
        System.out.println("minimum no of step to make two strings anagram are : "+result);
    }
    }

