// https://leetcode.com/problems/shift-2d-grid/description/

/*
	Given a 2D grid of size m x n and an integer k. You need to shift the grid k times.
	
	In one shift operation:
	
	Element at grid[i][j] moves to grid[i][j + 1].
	Element at grid[i][n - 1] moves to grid[i + 1][0].
	Element at grid[m - 1][n - 1] moves to grid[0][0].
	Return the 2D grid after applying shift operation k times.
	
	 
	
	Example 1:
	
	
	Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 1
	Output: [[9,1,2],[3,4,5],[6,7,8]]
	Example 2:
	
	
	Input: grid = [[3,8,1,9],[19,7,2,5],[4,6,11,10],[12,0,21,13]], k = 4
	Output: [[12,0,21,13],[3,8,1,9],[19,7,2,5],[4,6,11,10]]
	Example 3:
	
	Input: grid = [[1,2,3],[4,5,6],[7,8,9]], k = 9
	Output: [[1,2,3],[4,5,6],[7,8,9]]
	 
	
	Constraints:
	
	m == grid.length
	n == grid[i].length
	1 <= m <= 50
	1 <= n <= 50
	-1000 <= grid[i][j] <= 1000
	0 <= k <= 100
*/

package com.easy.problems;
import java.util.*;

public class Shift_2D_Grid {
	public List<List<Integer>> shiftGrid(int[][] grid, int l) {

        if(grid[0].length == 1)
            for(int i = 0; i < l%grid.length; i++){
                int temp = grid[grid.length-1][0];

                for(int j = grid.length - 1; j > 0; j--)
                    grid[j][0] = grid[j-1][0];

                grid[0][0] = temp;
            }
        else
            for(int i = 0; i < l%(grid.length*grid[0].length); i++){
                int temp = grid[grid.length-1][grid[0].length-1];

                for(int j = grid.length-1; j >= 0; j--)
                    for(int k = grid[0].length-1; k > 0; k--){
                        if(k == 1 && j == 0){
                            grid[j][k] = grid[j][k-1];
                            grid[j][0] = temp;
                            break;
                        }
                        if(k == 1){
                            grid[j][k] = grid[j][k-1];
                            grid[j][0] = grid[j-1][grid[0].length-1];
                            break;
                        }
                        grid[j][k] = grid[j][k-1];
                    }
            }

        List<List<Integer>> list = new ArrayList<List<Integer>>();

        for(int i = 0; i < grid.length; i++){
            List<Integer> int_List = new ArrayList<Integer>();

            for(int j = 0; j < grid[0].length; j++)
                int_List.add(grid[i][j]);

            list.add(int_List);
        }

        return list;
    }
}
