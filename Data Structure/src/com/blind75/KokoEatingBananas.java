package com.blind75;

public class KokoEatingBananas {

    //875. Koko Eating Bananas
    /*
    Koko loves to eat bananas. There are n piles of bananas, the ith pile has piles[i] bananas. The guards have gone and will come back in h hours.

Koko can decide her bananas-per-hour eating speed of k. Each hour, she chooses some pile of bananas and eats k bananas from that pile. If the pile has less than k bananas, she eats all of them instead and will not eat any more bananas during this hour.

Koko likes to eat slowly but still wants to finish eating all the bananas before the guards return.

Return the minimum integer k such that she can eat all the bananas within h hours.



Example 1:

Input: piles = [3,6,7,11], h = 8
Output: 4
Example 2:

Input: piles = [30,11,23,4,20], h = 5
Output: 30
Example 3:

Input: piles = [30,11,23,4,20], h = 6
Output: 23


Constraints:

1 <= piles.length <= 104
piles.length <= h <= 109
1 <= piles[i] <= 109
    * */

    public static void main(String[] args) {
        int [] weights = {30,11,23,4,20};
        int days = 5;
        int capacity = minEatingSpeed(weights,days);
        System.out.println("Capacity : "+capacity);
    }

    public static int minEatingSpeed(int[] piles, int h) {

        int start = 1;
        int end = 0;
        int ans = -1;

        for(int pile : piles){
            end = Math.max(pile,end);
        }

        while(start <= end){
            int mid = start + (end-start)/2;

            if(getHours(mid,piles) <= h){
                ans = mid;
                end = mid-1;
            }else{
                start = mid + 1;
            }
        }

        return ans;
    }

    public static int getHours(int capacity, int [] piles){

        int hours = 0;

        for(int pile : piles){
            hours += Math.ceil((double) pile/(double)capacity);
        }

        return hours;
    }
}
