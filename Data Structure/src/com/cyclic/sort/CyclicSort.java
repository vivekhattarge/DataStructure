package com.cyclic.sort;

public class CyclicSort {

    public static void main(String[] args) {
        int[] arr = new int[] { 3, 1, 5, 4, 2 };
        CyclicSort.sort(arr);
        for (int num : arr)
            System.out.print(num + " ");
    }

    private static void sort(int[] arr) {

        int i=0;
        while(i< arr.length){
            int value = arr[i]-1;
            if(value != i){
                CyclicSort.swap(arr,i,value);
            }else{
                i++;
            }
        }

    }

    private static void swap(int[] arr, int i, int value) {
        int temp = arr[value];
        arr[value] = arr[i];
        arr[i] = temp;

    }

}
