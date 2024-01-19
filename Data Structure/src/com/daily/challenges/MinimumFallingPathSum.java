package com.daily.challenges;

import java.util.Arrays;

public class MinimumFallingPathSum {
    public int minFallingPathSum(int[][] matrix) {
        final int n = matrix.length;

        for (int i = 1; i < n; ++i){
            for (int j = 0; j < n; ++j) {
                int min = Integer.MAX_VALUE;
                for (int k = Math.max(0, j - 1); k < Math.min(n, j + 2); ++k)
                    min = Math.min(min, matrix[i - 1][k]);
                matrix[i][j] += min;
            }
        }
        return Arrays.stream(matrix[n - 1]).min().getAsInt();
    }
    public static void main(String[] args) {
        int [][] matrix = {{2,1,3},{6,5,4},{7,8,9}};

        int result = new MinimumFallingPathSum().minFallingPathSum(matrix);

        System.out.println("Minimum Falling Path sum is : "+result);
    }
}
