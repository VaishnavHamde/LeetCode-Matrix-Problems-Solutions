// https://leetcode.com/problems/determine-whether-matrix-can-be-obtained-by-rotation/description/

/*
	Given two n x n binary matrices mat and target, return true if it is possible to make mat equal to target 
	by rotating mat in 90-degree increments, or false otherwise.
	
	
	Example 1:
	
	Input: mat = [[0,1],[1,0]], target = [[1,0],[0,1]]
	Output: true
	Explanation: We can rotate mat 90 degrees clockwise to make mat equal target.
	
	Example 2:
	
	Input: mat = [[0,1],[1,1]], target = [[1,0],[0,1]]
	Output: false
	Explanation: It is impossible to make mat equal to target by rotating mat.
	
	Example 3:
	
	Input: mat = [[0,0,0],[0,1,0],[1,1,1]], target = [[1,1,1],[0,1,0],[0,0,0]]
	Output: true
	Explanation: We can rotate mat 90 degrees clockwise two times to make mat equal target.
	 
	
	Constraints:
	
	n == mat.length == target.length
	n == mat[i].length == target[i].length
	1 <= n <= 10
	mat[i][j] and target[i][j] are either 0 or 1.
*/

package com.easy.problems;

public class Determine_Whether_Matrix_Can_Be_Obtained_By_Rotation {
	public boolean findRotation(int[][] mat, int[][] target) {
        int[][] temp = new int[mat[0].length][mat.length];
        int k = 0;

        for(int i = 0; i < mat.length; i++)
            for(int j = 0; j < mat[0].length; j++)
                temp[i][j] = mat[i][j];

        while(k < 4){
            boolean bool = true;

            for(int i = 0; i < temp.length; i++)
                for(int j = 0; j < temp[0].length; j++)
                    mat[i][j] = temp[i][j];

            for(int i = 0; i < mat.length; i++)
                for(int j = 0; j < mat[0].length; j++)
                    temp[j][i] = mat[i][j];

            for(int i = 0; i < temp.length; i++){
                int low = 0;
                int high = temp[0].length - 1;
                while(low < high){
                    int temp2 = temp[i][low];
                    temp[i][low] = temp[i][high];
                    temp[i][high] = temp2;
                    low++;
                    high--;
                }
            }

            for(int i = 0; i < temp.length; i++){
                for(int j = 0; j < temp[0].length; j++)
                    if(temp[i][j] != target[i][j]){
                        bool = false;
                        break;
                    }
                    
                if(!bool)
                    break;
            }

            if(bool)
                return true;

            k++;
        }

        return false;
    }
}
