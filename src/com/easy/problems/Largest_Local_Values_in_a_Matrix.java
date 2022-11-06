// https://leetcode.com/problems/largest-local-values-in-a-matrix/description/

/*
	You are given an n x n integer matrix grid.
	
	Generate an integer matrix maxLocal of size (n - 2) x (n - 2) such that:
	
	maxLocal[i][j] is equal to the largest value of the 3 x 3 matrix in grid centered around row i + 1 and column j + 1.
	In other words, we want to find the largest value in every contiguous 3 x 3 matrix in grid.
	
	Return the generated matrix.
	
	 
	Example 1:
	
	Input: grid = [[9,9,8,1],[5,6,2,6],[8,2,6,4],[6,2,2,2]]
	Output: [[9,9],[8,6]]
	Explanation: The diagram above shows the original matrix and the generated matrix.
	Notice that each value in the generated matrix corresponds to the largest value of a contiguous 3 x 3 matrix in grid.
	
	Example 2:
	
	
	Input: grid = [[1,1,1,1,1],[1,1,1,1,1],[1,1,2,1,1],[1,1,1,1,1],[1,1,1,1,1]]
	Output: [[2,2,2],[2,2,2],[2,2,2]]
	Explanation: Notice that the 2 is contained within every contiguous 3 x 3 matrix in grid.
	 
	
	Constraints:
	
	n == grid.length == grid[i].length
	3 <= n <= 100
	1 <= grid[i][j] <= 100
*/

package com.easy.problems;

public class Largest_Local_Values_in_a_Matrix {
	public int[][] largestLocal(int[][] grid) {
        int[] arr = new int[(grid.length-2)*(grid.length-2)];
        int m = 0;

        for(int k = 0; k < grid.length-2; k++)
            for(int l = 0; l < grid.length-2; l++){
                int max = Integer.MIN_VALUE;
                for(int i = k; i < k+3; i++){
                    for(int j = l; j < l+3; j++)
                        max = Math.max(max, grid[i][j]);
                }

                arr[m] = max;
                m++;
            }

        m = 0;
        int[][] ans = new int[grid.length-2][grid.length-2];

        for(int i = 0; i < ans.length; i++)
            for(int j = 0; j < ans.length; j++){
                ans[i][j] = arr[m];
                m++;
            }

        return ans;
    }
}
