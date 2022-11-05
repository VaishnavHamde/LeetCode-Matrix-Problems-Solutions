// https://leetcode.com/problems/kth-smallest-element-in-a-sorted-matrix/description/

/*
	Given an n x n matrix where each of the rows and columns is sorted in ascending order, return the kth smallest element in the matrix.
	
	Note that it is the kth smallest element in the sorted order, not the kth distinct element.
	
	You must find a solution with a memory complexity better than O(n2).
	
	
	Example 1:
	
	Input: matrix = [[1,5,9],[10,11,13],[12,13,15]], k = 8
	Output: 13
	Explanation: The elements in the matrix are [1,5,9,10,11,12,13,13,15], and the 8th smallest number is 13
	
	Example 2:
	
	Input: matrix = [[-5]], k = 1
	Output: -5
	 
	
	Constraints:
	
	n == matrix.length == matrix[i].length
	1 <= n <= 300
	-109 <= matrix[i][j] <= 109
	All the rows and columns of matrix are guaranteed to be sorted in non-decreasing order.
	1 <= k <= n2
*/

package com.medium.problems;

public class Kth_Smallest_Element_in_a_Sorted_Matrix {
	public int kthSmallest(int[][] matrix, int k) {
        int low = matrix[0][0];
        int high = matrix[matrix.length - 1][matrix.length - 1];

        while(low != high){
            int mid = (low+high)/2;
            int count = count(matrix, mid);

            if(count < k)
                low = mid + 1;
            else{
                if(mid < 0)
                    high = mid-1;
                else 
                    high = mid;
            }
        }

        return low;
    }

    int count(int[][] matrix, int mid){
        int r = 0;
        int c = matrix.length - 1;
        int count = 0;

        while(r < matrix.length && c >= 0){
            if(matrix[r][c] > mid)
                c--;
            else{
                count += c + 1;
                r++;
            }
        }

        return count;
    }
}
