package com.two.pointer;

public class RemoveKeyFromUnsortedArray {

    public static void main(String[] args) {
        int [] inputArray = new int[] {3,2,3,6,3,10,9,3};
        int key = 3;
        System.out.println("length after removing key is " + getLengthAfterRemovingKey(inputArray,key));
    }

    private static int getLengthAfterRemovingKey(int[] inputArray, int key) {

        int nextElement=0;

        for (int i = 0; i < inputArray.length; i++) {
            if(inputArray[i] != key){
              inputArray[nextElement] = inputArray[i];
                nextElement++;
            }

        }
        return nextElement;
    }

}
