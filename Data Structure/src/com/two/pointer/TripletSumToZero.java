package com.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletSumToZero {

    public static void main(String[] args) {
        int [] inputArray = new int[]{-3,0,1,2,-1,1,-2};
        List<List<Integer>> resultTriplets = getTriplets(inputArray);

        System.out.println("result : "+ resultTriplets.toString() );
    }

    private static List<List<Integer>> getTriplets(int[] inputArray) {
        Arrays.sort(inputArray);
        List<List<Integer>> triplet = new ArrayList<>();

        for (int i = 0; i < inputArray.length - 2; i++) {

            if(i > 0 && inputArray[i] == inputArray[i-1]){
                continue;
            }
            searchPair(inputArray,-inputArray[i],i+1,triplet);
        }

        return triplet;
    }

    private static void searchPair(int[] inputArray, int targetSum, int left, List<List<Integer>> triplet) {

        int right = inputArray.length-1;
        while (left < right) {

            int currentSum = inputArray[left] + inputArray[right];
            if(currentSum == targetSum){
                triplet.add(Arrays.asList(-targetSum,inputArray[left],inputArray[right]));
                left++;
                right--;
                //if we found duplicates while finding pair then below two while  loops will ignore duplicates

                while (left<right && inputArray[left] == inputArray[left-1]){
                    left++;
                }

                while (left<right && inputArray[right] == inputArray[right+1]){
                    right--;
                }
            }else if(currentSum < targetSum){
                left++;
            }else{
                right--;
            }
        }
    }

}
