package com.blind75;

import java.util.HashSet;
import java.util.Set;

public class FindDuplicateElementPresent {

    public static void main(String[] args) {

      int []  nums = {1,2,3,1};

        System.out.println("is duplicate present : "+containsDuplicate(nums));

    }

   static boolean containsDuplicate(int[] nums) {

        Set<Integer> set = new HashSet<>();

        for(int num : nums){

            if(set.contains(num)){
                return true;
            }else{
                set.add(num);
            }


        }

        return false;
    }
}

