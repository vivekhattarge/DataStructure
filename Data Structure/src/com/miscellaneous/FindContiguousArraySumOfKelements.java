package com.miscellaneous;

import java.util.Arrays;

public class FindContiguousArraySumOfKelements {

    public static void main(String[] args) {

        int [] inputArray = new int[] {1, 3, 2, 6, -1, 4, 1, 8, 2};
        int subArrayNumber = 5;
        double [] result  = getSumOfContegiousArray(inputArray,subArrayNumber);

        System.out.println("result : "+ Arrays.toString(result));
    }

    private static double[] getSumOfContegiousArray(int[] inputArray, int subArrayNumber) {
        double [] result=new double[inputArray.length];
        // this is going to be iteration counter
        int start = 0;
        //int end;
        double windowSum =0;
        int resultArrayIndex=0;
        for(int currentElement : inputArray){
            start += 1;
            windowSum += currentElement;

            if(start >= subArrayNumber){
                result[resultArrayIndex] = windowSum/subArrayNumber;
                resultArrayIndex += 1;

                // this will minus first number from window sum
                windowSum -= inputArray[start-subArrayNumber];
            }
        }
        return result;
    }

}
