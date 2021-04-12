package com.misc;

public class RomanToDecimal {

    public static void romanToDecimal(String roman) {
        int sum = 0;
        int previous = 0;

        for (int x = roman.length() - 1; x >= 0 ; x--) {
            char convertToDecimal = roman.charAt(x);
            switch (convertToDecimal) {

                case 'I':
                    sum = getValue(1, previous, sum);
                    previous = 1;
                    break;
                case 'V':
                    sum = getValue(5, previous, sum);
                    previous = 5;
                    break;
                case 'C':
                    sum = getValue(100, previous, sum);
                    previous = 100;
                    break;

                case 'M':
                    sum = getValue(1000, previous, sum);
                    previous = 1000;
                    break;
                case 'X':
                    sum = getValue(10, previous, sum);
                    previous = 10;
                    break;
                case 'D':
                    sum = getValue(500, previous, sum);
                    previous = 500;
                    break;
                case 'L':
                    sum = getValue(50, previous, sum);
                    previous = 50;
                    break;
            }
        }

        System.out.println(sum);
    }

    public static int getValue(int decimal, int previous, int previousDecimal) {
        if (previous > decimal) {
            return previousDecimal - decimal;
        } else {
            return previousDecimal + decimal;
        }
    }

    public static void main(java.lang.String args[]) {
        romanToDecimal("MMVIII");
    }
}