package com.two.pointer;

import java.util.ArrayList;
import java.util.List;

public class ShortestWindowSort {

    public static void main(String[] args) {

        int[] inputArray = new int[]{1, 3, 2, 0, -1, 7, 10};
        List<Integer> shortestWindow = getShortestWindowToSort(inputArray);
        System.out.println("Shortest window to sort is : " + shortestWindow.toString());

    }

    private static List<Integer> getShortestWindowToSort(int[] inputArray) {

        List<Integer> resultWindow = new ArrayList<>();
        int low = 0;
        int high = inputArray.length - 1;

        while (low < inputArray.length - 1 && inputArray[low] < inputArray[low + 1]) {
            low++;
        }

        if (low == inputArray.length - 1) {
            return resultWindow;
        }

        while (high > 0 && inputArray[high] > inputArray[high - 1]) {
            high--;
        }
        int subArrayMin = Integer.MAX_VALUE;
        int subArrayMax = Integer.MIN_VALUE;

        for (int k = low; k <= high; k++) {
            subArrayMin = Math.min(subArrayMin, inputArray[k]);
            subArrayMax = Math.max(subArrayMax, inputArray[k]);
        }

        while (low > 0 && inputArray[low - 1] > subArrayMin) {
            low--;
        }

        while (high < inputArray.length - 1 && inputArray[high + 1] < subArrayMax) {
            high++;
        }
        for (int i = low; i <= high; i++) {
            resultWindow.add(inputArray[i]);
        }
        return resultWindow;
    }

}
