package com.cyclic.sort;

public class FindAllDuplicateNumbersFromUnsortedArray {

    public static void main(String[] args) {
        int [] inputArray = new int[]{5,4,7,2,3,5,3};

        int [] result = sort(inputArray);

        for (int i = 0; i < result.length; i++) {
            if (result[i] != i + 1)
                System.out.print(" "+result[i]);
        }

    }

    private static int[] sort(int[] inputArray) {
        int i=0;
        while (i < inputArray.length){
                if(inputArray[i] != inputArray[inputArray[i]-1]){
                    swap(inputArray,i,inputArray[i]-1);
                }else{
                    i++;
                }
        }
        return inputArray;
    }

    private static void swap(int [] inputArray,int i,int j){
        int temp = inputArray[i];
        inputArray[i] = inputArray[j];
        inputArray[j]=temp;
    }

}
