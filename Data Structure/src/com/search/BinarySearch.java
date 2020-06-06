package com.search;

public class BinarySearch {

    public static void main(String[] args) {
        Integer [] inputArray = {10,20,30,40,50,60,70};
        int indexOfKeyElement = searKeyInArray(inputArray,30);
        System.out.println("index is : "+indexOfKeyElement);
    }

    private static int searKeyInArray(Integer[] inputArray, int key) {

        int low=0;
        int high = inputArray.length-1;
        while (low < high){
            int midIndex = low + (high-low)/2;
            if(inputArray[midIndex]==key){
                return midIndex;
            }
           if(inputArray[midIndex] > key){
            high = midIndex;
           }else{
            low = midIndex;
           }
        }
        return -1;
    }
}
