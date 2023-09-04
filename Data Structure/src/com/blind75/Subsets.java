package com.blind75;

import java.util.ArrayList;
import java.util.List;
/*

78. Subsets

Given an integer array nums of unique elements, return all possible
subsets
 (the power set).

The solution set must not contain duplicate subsets. Return the solution in any order.



Example 1:

Input: nums = [1,2,3]
Output: [[],[1],[2],[1,2],[3],[1,3],[2,3],[1,2,3]]
Example 2:

Input: nums = [0]
Output: [[],[0]]

* */
class Subsets {
    public List<List<Integer>> subsetsWithDup(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        List<Integer> subset = new ArrayList<>();
        helper(0,ans,nums,subset);
        return ans;
    }

    public void helper(int i, List<List<Integer>> ans, int [] nums,List<Integer> subset){

        if(i == nums.length){
            List<Integer> ds = new ArrayList<>(subset);
            ans.add(ds);
            return;
        }

        subset.add(nums[i]);
        helper(i+1,ans,nums,subset);

        subset.remove(subset.size()-1);
        helper(i+1,ans,nums,subset);


    }
    public static void main(String args[]) {
        int nums[]={1,2,3};
        List<List<Integer>> ans = new Subsets().subsetsWithDup(nums);
        System.out.println(ans);

    }
}