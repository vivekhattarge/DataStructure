package com.striver;

public class SetMatrixZero1 {

/*
    Examples 1:

    Input: matrix=[[1,1,1],[1,0,1],[1,1,1]]

    Output: [[1,0,1],[0,0,0],[1,0,1]]

    Explanation: Since matrix[2][2]=0.Therfore the 2nd column and 2nd row wil be set to 0.

    Input: matrix=[[0,1,2,0],[3,4,5,2],[1,3,1,5]]

    Output:[[0,0,0,0],[0,4,5,0],[0,3,1,0]]

    Explanation:Since matrix[0][0]=0 and matrix[0][3]=0. Therefore 1st row, 1st column and 4th column will be set to 0
*/


/*
    Solution 2:Better approach

    Intuition: Instead of traversing through each row and column, we can use dummy arrays to check if the particular row or column has an element 0 or not, which will improve the time complexity.

            Approach:Take two dummy array one of size of row and other of size of column.Now traverse through the array.If matrix[i][j]==0 then set dummy1[i]=0(for row) and dummy2[j]=0(for column).Now traverse through the array again and if dummy1[i]==0  || dummy2[j]==0 then arr[i][j]=0,else continue.
*/

    public static void main(String[] args) {

        int arr[][] = {{0, 1, 2, 0}, {3, 4, 5, 2}, {1, 3, 1, 5}};
        setZeroes(arr);
        System.out.println("The Final Matrix is ");
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                System.out.print(arr[i][j] + " ");
            }
            System.out.println();
        }

    }

    private static void setZeroes(int[][] arr) {

        int rows = arr.length;
        int columns = arr[0].length;
        int [] rowElements = new int[rows];
        int [] colElements = new int[columns];

        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){

                if(arr[i][j] ==0){
                    rowElements[i] = -1;
                    colElements[j] = -1;
                }

            }
        }

        for(int i=0; i<rows;i++){
            for(int j=0;j<columns;j++){

                if(rowElements[i] ==-1 || colElements[j] == -1){

                    arr[i][j] = 0;
                }

            }
        }



    }
}
