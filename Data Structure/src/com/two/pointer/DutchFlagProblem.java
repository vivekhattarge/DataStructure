package com.two.pointer;

import java.util.Arrays;

public class DutchFlagProblem {

    public static void main(String[] args) {

        int[] inputArray = new int[]{1,0,2,1,0};
        sortDutchFlagProblemInPlace(inputArray);
        System.out.print("result is :" );
        for(int element : inputArray){
            System.out.print(" "+element);
        }

    }

    private static void sortDutchFlagProblemInPlace(int[] inputArray) {
        int low = 0;
        int high = inputArray.length - 1;
        int i = 0;

        while (i < high) {

            if(inputArray[i] == 0){
                swap(inputArray,i,low);
                low++;
                i++;
            }else if(inputArray[i] == 2){
                swap(inputArray,i,high);
                high--;
            }else{
                i++;
            }

        }

    }

    private static void swap(int[] inputArray, int i, int replaceablePlace) {
        int temp = inputArray[replaceablePlace];
        inputArray[replaceablePlace] = inputArray[i];
        inputArray[i] = temp;
    }

}
