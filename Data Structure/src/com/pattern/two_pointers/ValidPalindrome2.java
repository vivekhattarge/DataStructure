package com.pattern.two_pointers;

public class ValidPalindrome2 {
    public static void main(String[] args) {

        String input = "abcdefghijklmnopqrstuvwxyzABCDEFGGFEDCBAzyxwvutsrqponmlkjihgfedcbaz";
        System.out.println("isPalindrome : "+isPalindrome(input));
    }

    public static boolean isPalindrome(String input) {

        int start = 0;
        int end = input.length()-1;

        while(start < end){

            //if characters matched
            if(input.charAt(start) == input.charAt(end)){
                start++;
                end--;
            }else{
            //characters did not match

                return checkPalindrome(input,start+1,end) || checkPalindrome(input,start,end-1);
            //skip start
            }
        }
        return true;
    }

    private static boolean checkPalindrome(String input, int start, int end) {
        while (start < end){
            if(input.charAt(start) == input.charAt(end)){
                start++;
                end--;
            }else{
                return false;
            }
        }
        return true;
    }
}
