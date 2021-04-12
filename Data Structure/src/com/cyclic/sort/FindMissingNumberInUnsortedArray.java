package com.cyclic.sort;

public class FindMissingNumberInUnsortedArray {

    public static void main(String[] args) {

        System.out.println("Missing number is  : "+FindMissingNumberInUnsortedArray.findMissingNumber(new int[] { 4, 0, 3, 1 }));

    }

    private static int findMissingNumber(int[] arr) {

        int result = 0;
        int i=0;
        while (i<arr.length){
          //  int value = arr[i];
            if((arr[i]<arr.length) && (arr[i] != arr[arr[i]])) {
                FindMissingNumberInUnsortedArray.swap(arr,i,arr[i]);
            }else{
                i++;
            }
        }
        for(int j=0;j<arr.length;j++){
            if(j != arr[j]){
                return j;
            }
        }
        return result;
    }

    private static void swap(int[] arr, int i, int value) {
        int temp = arr[i];
        arr[i] = arr[value];
        arr[value] = temp;
    }

}
