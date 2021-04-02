package com.two.pointer;

import java.util.Arrays;

public class SquaringSortedArray {

    public static void main(String[] args) {
        int inputArray [] = new int[]{-2,-1,0,2,3};

        int [] resultArray = getSquaredArray(inputArray);

        System.out.println("squares is : "+ Arrays.toString(resultArray));
    }

    private static int[] getSquaredArray(int[] inputArray) {
        int [] squares = new int [inputArray.length];

        int left=0;
        int right=inputArray.length-1;
        int highestIndex=inputArray.length-1;
        while (left < right){

            int leftSquares = inputArray[left] * inputArray[left];
            int rightSquares = inputArray[right] * inputArray[right];

            if(leftSquares > rightSquares){
                squares[highestIndex--] = leftSquares;
                left++;
            }else{
                squares[highestIndex--] = rightSquares;
                right--;
            }

        }

        return squares;
    }

}
