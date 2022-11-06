// https://leetcode.com/problems/count-negative-numbers-in-a-sorted-matrix/description/

/*
	Given a m x n matrix grid which is sorted in non-increasing order both row-wise and column-wise, 
	return the number of negative numbers in grid.
	
	
	Example 1:
	
	Input: grid = [[4,3,2,-1],[3,2,1,-1],[1,1,-1,-2],[-1,-1,-2,-3]]
	Output: 8
	Explanation: There are 8 negatives number in the matrix.
	
	Example 2:
	
	Input: grid = [[3,2],[1,0]]
	Output: 0
	 
	
	Constraints:
	
	m == grid.length
	n == grid[i].length
	1 <= m, n <= 100
	-100 <= grid[i][j] <= 100
	 
*/

package com.easy.problems;

public class Count_Negative_Numbers_in_a_Sorted_Matrix {
	public int countNegatives(int[][] grid) {
        int i = grid.length-1;
        int j = 0;
        int count = 0;
        
        while(i>=0 && j<grid[0].length){
            if(grid[i][j] >= 0)
                j++;
            else{
                count += grid[0].length - j;
                i--;
            }
        }

        return count;
    }
}
