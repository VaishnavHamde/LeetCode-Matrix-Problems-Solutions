// https://leetcode.com/problems/rotating-the-box/description/

/*
	You are given an m x n matrix of characters box representing a side-view of a box. Each cell of the box is one of the following:
	
	A stone '#'
	A stationary obstacle '*'
	Empty '.'
	The box is rotated 90 degrees clockwise, causing some of the stones to fall due to gravity. 
	Each stone falls down until it lands on an obstacle, another stone, or the bottom of the box. 
	Gravity does not affect the obstacles' positions, and the inertia from the box's rotation does not affect the stones' horizontal positions.
	
	It is guaranteed that each stone in box rests on an obstacle, another stone, or the bottom of the box.
	
	Return an n x m matrix representing the box after the rotation described above.
	
	
	Example 1:
	
	Input: box = [["#",".","#"]]
	Output: [["."],
	         ["#"],
	         ["#"]]
	         
	Example 2:
	
	
	Input: box = [["#",".","*","."],
	              ["#","#","*","."]]
	Output: [["#","."],
	         ["#","#"],
	         ["*","*"],
	         [".","."]]
	         
	Example 3:
	
	
	
	Input: box = [["#","#","*",".","*","."],
	              ["#","#","#","*",".","."],
	              ["#","#","#",".","#","."]]
	Output: [[".","#","#"],
	         [".","#","#"],
	         ["#","#","*"],
	         ["#","*","."],
	         ["#",".","*"],
	         ["#",".","."]]
	 
	Constraints:
	
	m == box.length
	n == box[i].length
	1 <= m, n <= 500
	box[i][j] is either '#', '*', or '.'.
*/

package com.medium.problems;

public class Rotating_the_Box {
	public char[][] rotateTheBox(char[][] box) {

        for(int i = 0; i < box.length; i++){
            int count = 0;

            for(int j = 0; j < box[0].length; j++)
                if(box[i][j] == '#')
                    count++;

            while(count > 0)
                for(int j = 1; j < box[0].length; j++)
                    if(box[i][j-1] == '#' && box[i][j] == '.'){
                        char temp = box[i][j];
                        box[i][j] = box[i][j-1];
                        box[i][j-1] = temp;
                    }

                count--;
        }

        char[][] ans = new char[box[0].length][box.length];

        for(int i = 0; i < box.length; i++)
            for(int j = 0; j < box[0].length; j++)
                ans[j][i] = box[i][j];

        for(int i = 0; i < ans.length; i++){
            int low = 0;
            int high = ans[0].length-1;

            while(low < high){
                char temp = ans[i][low];
                ans[i][low] = ans[i][high];
                ans[i][high] = temp;
                low++;
                high--;
            }
        }

        return ans;
    }
}