package com.pattern.two_pointers;

import java.util.Arrays;

public class SortColors {
    public static void main(String[] args) {
        int [] colors = {0,1,0};
        int [] result = sortColors(colors);
        Arrays.stream(result).forEach(System.out::print);
    }
    public static int[] sortColors (int[] colors) {

        int low =0;
        int current=0;
        int high=colors.length-1;

        while(current <= high){

            if(colors[current] == 1){
                current++;
            }else if(colors[current] == 0){
                int temp = colors[current];
                colors[current] = colors[low];
                colors[low] = temp;
                low++;
                current++;
            }else {
                int temp = colors[current];
                colors[current] = colors[high];
                colors[high] = temp;
                high--;
            }

        }

        return colors;
    }
}
