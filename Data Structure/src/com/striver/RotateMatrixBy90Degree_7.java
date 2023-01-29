package com.striver;

public class RotateMatrixBy90Degree_7 {

    public static void main(String[] args) {

        int arr[][] = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        rotate(arr);
        System.out.println("Rotated Image");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr.length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static void rotate(int[][] matrix) {

        //Step 1 : transpose of matrix
        // interchange rows to columns and columns to rows
        for (int i = 0; i < matrix.length; i++) {
            for (int j = i; j < matrix[0].length; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }

        //Step 2 : reverse matrix
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length/2; j++) {

                int temp = matrix[i][matrix.length-1-j];
                matrix[i][matrix.length-1-j] = matrix[i][j];
                matrix[i][j] = temp;

            }
        }

    }

}


