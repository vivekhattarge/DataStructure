package com.two.pointer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class TripletWithSmallerThanTarget {

    public static void main(String[] args) {
        int[] inputArray = new int[]{-1, 0, 2, 3};
        int target = 3;
        List<List<Integer>> result = getTripletSmallerThanTarget(inputArray, target);
        System.out.println("result triplet : " + result.toString());
    }

    private static List<List<Integer>> getTripletSmallerThanTarget(int[] inputArray, int target) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 0; i < inputArray.length - 2; i++) {
            searchPair(inputArray, target, i, i + 1, result);
        }
        return result;
    }

    private static void searchPair(int[] inputArray, int targetSum, int currentElement, int left, List<List<Integer>> result) {

        int right = inputArray.length - 1;
        while (left < right) {
            int currentSum = inputArray[currentElement] + inputArray[left] + inputArray[right];
            if (currentSum < targetSum) {
                for (int i = right; i > left; i--) {
                    result.add(Arrays.asList(inputArray[currentElement], inputArray[left], inputArray[i]));
                }
                left++;
            } else {
                right--;
            }
        }
    }
}
