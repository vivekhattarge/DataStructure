package com.blind75;

import java.util.ArrayList;
import java.util.List;

/*
46. Permutations

* Given an array nums of distinct integers, return all the possible permutations. You can return the answer in any order.

Example 1:

Input: nums = [1,2,3]
Output: [[1,2,3],[1,3,2],[2,1,3],[2,3,1],[3,1,2],[3,2,1]]
Example 2:

Input: nums = [0,1]
Output: [[0,1],[1,0]]
Example 3:

Input: nums = [1]
Output: [[1]]

* */
class Permutations {
    public static void main(String[] args) {
        int nums[] = {1,2,3};
        Permutations sol = new Permutations();
        List < List < Integer >> ls = sol.permute(nums);
        System.out.println("All Permutations are ");
        for (int i = 0; i < ls.size(); i++) {
            for (int j = 0; j < ls.get(i).size(); j++) {
                System.out.print(ls.get(i).get(j) + " ");
            }
            System.out.println();
        }
    }
    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();

        help(0,ans,nums);
        return ans;
    }

    public void help(int i, List<List<Integer>> ans, int[] nums){
        if(i == nums.length){
            List<Integer> ds = new ArrayList<>();
            for(int num : nums){
                  ds.add(num);  
            }
            ans.add(ds);
            return;
        }
        for(int j=i;j<nums.length;j++){
             swap(i,j,nums);
             help(i+1,ans,nums);
             swap(j,i,nums);   
        }

    }

    public void swap(int i, int j, int[] nums) {
          int temp = nums[i];
           nums[i] = nums[j];
           nums[j]  = temp;   
    }

}