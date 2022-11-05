// https://leetcode.com/problems/search-a-2d-matrix/description/

/*
	Write an efficient algorithm that searches for a value target in an m x n integer matrix matrix. This matrix has the following properties:
	
	Integers in each row are sorted from left to right.
	The first integer of each row is greater than the last integer of the previous row.
	 
	
	Example 1:
	
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 3
	Output: true
	
	Example 2:
	
	Input: matrix = [[1,3,5,7],[10,11,16,20],[23,30,34,60]], target = 13
	Output: false
	 

	Constraints:
	
	m == matrix.length
	n == matrix[i].length
	1 <= m, n <= 100
	-104 <= matrix[i][j], target <= 104
*/

package com.medium.problems;

public class Search_a_2D_Matrix {
	public boolean searchMatrix(int[][] matrix, int target) {

        for(int i = 0; i < matrix.length; i++){
            int low = 0;
            int high = matrix[0].length - 1;

            if(matrix[i][matrix[0].length - 1] < target)
                continue;
                
            while(low <= high){
                int mid = (low+high)/2;
                if(matrix[i][mid] == target)
                    return true;
                if(matrix[i][mid] > target)
                    high = mid - 1;
                else
                    low = mid + 1;
            }
        }

        return false;
    }
}
