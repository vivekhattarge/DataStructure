package com.pattern;

public class ValidPalindrome {
    public static void main(String[] args) {
        String s = "abba";
        boolean result = isPalindrome(s);

        if(result){
            System.out.println("Palindrome");
        }else{
            System.out.println("Not Palindrome");
        }
    }

    private static boolean isPalindrome(String s) {
        boolean result = true;
        int start = 0;
        int end = s.length()-1;
        while(start < end){
            if(s.charAt(start) == s.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return result;
    }
}
