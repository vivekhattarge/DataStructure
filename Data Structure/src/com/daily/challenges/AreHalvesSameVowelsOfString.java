package com.daily.challenges;

/*
You are given a string s of even length. Split this string into two halves of equal lengths, and let a be the first half and b be the second half.

        Two strings are alike if they have the same number of vowels ('a', 'e', 'i', 'o', 'u', 'A', 'E', 'I', 'O', 'U'). Notice that s contains uppercase and lowercase letters.

        Return true if a and b are alike. Otherwise, return false.



        Example 1:

        Input: s = "book"
        Output: true
        Explanation: a = "bo" and b = "ok". a has 1 vowel and b has 1 vowel. Therefore, they are alike.
*/


public class AreHalvesSameVowelsOfString {
        public boolean halvesAreAlike(String s) {
            int mid = s.length()/2;

            int firstHalfVowels = getVowelsCount(s.substring(0,mid));
            int secondHalfVowels = getVowelsCount(s.substring(mid,s.length()));

            return (firstHalfVowels == secondHalfVowels);
        }

        int getVowelsCount(String s){
            char [] letters = s.toCharArray();
            int count = 0;
            for(char letter : letters){
                if(isVowel(letter)){
                    count++;
                }
            }

            return count;
        }
        boolean isVowel(char letter){
            if(letter == 'A' || letter == 'a'){
                return true;
            }else if(letter == 'E' || letter == 'e'){
                return true;
            }else if (letter == 'I' || letter == 'i'){
                return true;
            }else if (letter == 'O' || letter == 'o'){
                return true;
            }else if(letter == 'U' || letter == 'u'){
                return true;
            }
            else{
                return false;
            }
        }

    public static void main(String[] args) {
        String inputString = "book";

        boolean result = new AreHalvesSameVowelsOfString().halvesAreAlike(inputString);
        if(result){
            System.out.println("Halves are same");
        }else{
            System.out.println("Halves have different vowels");
        }
    }
    }

