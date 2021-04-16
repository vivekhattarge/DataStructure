package com.cyclic.sort;

public class FindSmallestMissingPositiveNumber {

    public static void main(String[] args) {
        int [] inputArray = new int[]{-3,1,5,4,2};
        int [] result = sort(inputArray);

        int resultNumber=-1;
        for(int i=0;i< result.length;i++){
            if(i+1 != result[i]){
                resultNumber = i+1;
                break;
            }
        }
        System.out.println("Index of Smallest positive missing number is : "+resultNumber);
    }

    private static int[] sort(int[] inputArray) {

        int i=0;
        while (i<inputArray.length){

            if(inputArray[i] > 0 && inputArray[i] <= inputArray.length && inputArray[i] != inputArray[inputArray[i]-1]){
                swap(inputArray,i,inputArray[i]-1);
            }else{
                i++;
            }

        }

        return inputArray;
    }

    private static void swap(int [] inputArray,int i, int j){

        int temp = inputArray[j];
        inputArray[j] = inputArray[i];
        inputArray[i]=temp;

    }

}
