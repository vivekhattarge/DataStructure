package com.striver;


/*
        next_permutation : find next lexicographically greater permutation
        Problem Statement: Given an array Arr[] of integers, rearrange the numbers of the given array into the lexicographically next greater permutation of numbers.

        If such an arrangement is not possible, it must rearrange it as the lowest possible order (i.e., sorted in ascending order).

        Example 1 :

        Input format: Arr[] = {1,3,2}

        Output: Arr[] = {2,1,3}

        Explanation: All permutations of {1,2,3} are {{1,2,3} , {1,3,2}, {2,13} , {2,3,1} , {3,1,2} , {3,2,1}}. So, the next permutation just after {1,3,2} is {2,1,3}.
        Example 2:

        Input format: Arr[] = {3,2,1}

        Output: Arr[] = {1,2,3}

        Explanation: As we see all permutations of {1,2,3}, we find {3,2,1} at the last position. So, we have to return the topmost permutation.
*/


public class LexicographicallyNextPermutation3 {

    public static void main(String[] args) {

        int[] ipArray = {3,2,1};
        nextPermutation(ipArray);

        System.out.println("Next permutation number is : ");
        for (int num : ipArray) {
            System.out.print(num + " ");
        }
    }

    private static void nextPermutation(int[] ipArray) {

        if (ipArray == null || ipArray.length <= 1) {
            return;
        }

        int idx1 = ipArray.length - 2;

        while (idx1 >= 0 && ipArray[idx1] >= ipArray[idx1 + 1]) {
            idx1--;
        }

        if (idx1 >= 0) {
            int idx2 = ipArray.length - 1;
            while (ipArray[idx1] >= ipArray[idx2]) {
                idx2--;
            }
            swap(ipArray, idx1, idx2);
        }

        reverse(ipArray, idx1 + 1, ipArray.length - 1);

    }

    private static void reverse(int[] ipArray, int i, int j) {
        while (i < j) {
            swap(ipArray, i, j);
            i++;
            j--;
        }
    }

    private static void swap(int[] ipArray, int idx1, int idx2) {
        int temp = ipArray[idx1];
        ipArray[idx1] = ipArray[idx2];
        ipArray[idx2] = temp;
    }
}
