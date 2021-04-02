package com.two.pointer;

public class RemoveDuplicatesFromSortedArray {

    public static void main(String[] args) {

        int [] inputArray = new int[]{2,3,3,3,6,9,9};

        System.out.println("array after removing duplicates : "+ remove(inputArray));

    }

    private static int remove(int[] inputArray) {
        int nextNonDuplicate=1;

        for(int i =1;i<inputArray.length;i++){
            if(inputArray[nextNonDuplicate-1] != inputArray[i]){
                inputArray[nextNonDuplicate] = inputArray[i];
                nextNonDuplicate++;
            }
        }

        return nextNonDuplicate;
    }

}
