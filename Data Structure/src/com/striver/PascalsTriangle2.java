package com.striver;

/*
Problem Statement: Given an integer N, return the first N rows of Pascal’s triangle.

In Pascal’s triangle, each number is the sum of the two numbers directly above it as shown in the figure

        Input Format: N = 5

        Result:
        1
        1 1
        1 2 1
        1 3 3 1
        1 4 6 4 1

        Explanation: There are 5 rows in the output matrix. Each row corresponds to each one of the rows in the image shown above.
*/

import java.util.ArrayList;
import java.util.List;

public class PascalsTriangle2 {

    public static void main(String[] args) {

        System.out.println("reached");
        List<List<Integer>> result = generate(5);

        System.out.println(result.toString());


    }

    public static List<List<Integer>> generate(int numRows) {
        List<List<Integer>> res = new ArrayList<List<Integer>>();
        List<Integer> row, pre = null;
        for (int i = 0; i < numRows; ++i) {
            row = new ArrayList<Integer>();
            for (int j = 0; j <= i; ++j)
                if (j == 0 || j == i)
                    row.add(1);
                else
                    row.add(pre.get(j - 1) + pre.get(j));
            pre = row;
            res.add(row);
        }
        return res;
    }

}
