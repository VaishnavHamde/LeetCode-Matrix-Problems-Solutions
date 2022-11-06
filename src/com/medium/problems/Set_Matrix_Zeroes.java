// https://leetcode.com/problems/set-matrix-zeroes/description/

/*
	Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.
	
	You must do it in place.
	
	 
	Example 1:
	
	
	Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
	Output: [[1,0,1],[0,0,0],[1,0,1]]
	
	Example 2:
	
	
	Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
	Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]
	 
	
	Constraints:
	
	m == matrix.length
	n == matrix[0].length
	1 <= m, n <= 200
	-231 <= matrix[i][j] <= 231 - 1
*/

package com.medium.problems;
import java.util.*;

public class Set_Matrix_Zeroes {
	public void setZeroes(int[][] matrix) {
        HashMap<Integer,Integer> hm1 = new HashMap<>();
        HashMap<Integer,Integer> hm2 = new HashMap<>();

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0)
                    hm1.put(i,j);

        for(int i = 0; i < matrix.length; i++)
            for(int j = 0; j < matrix[0].length; j++)
                if(matrix[i][j] == 0)
                    hm2.put(j,i);

        for(Map.Entry entry : hm1.entrySet())
            make0s1((int)entry.getKey(), (int)entry.getValue(), matrix);

        for(Map.Entry entry : hm2.entrySet())
            make0s2((int)entry.getKey(), (int)entry.getValue(), matrix);
    }

    void make0s1(int i, int j, int[][] matrix){

        for(int k = 0; k < matrix[0].length; k++)
            matrix[i][k] = 0;

        for(int k = 0; k < matrix.length; k++)
            matrix[k][j] = 0;
    }

    void make0s2(int j, int i, int[][] matrix){

        for(int k = 0; k < matrix[0].length; k++)
            matrix[i][k] = 0;

        for(int k = 0; k < matrix.length; k++)
            matrix[k][j] = 0;
    }
}
