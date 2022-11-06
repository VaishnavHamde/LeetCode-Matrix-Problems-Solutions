// https://leetcode.com/problems/valid-sudoku/description/

/*
	Determine if a 9 x 9 Sudoku board is valid. Only the filled cells need to be validated according to the following rules:
	
	Each row must contain the digits 1-9 without repetition.
	Each column must contain the digits 1-9 without repetition.
	Each of the nine 3 x 3 sub-boxes of the grid must contain the digits 1-9 without repetition.
	Note:
	
	A Sudoku board (partially filled) could be valid but is not necessarily solvable.
	Only the filled cells need to be validated according to the mentioned rules.
	 
	
	Example 1:
	
	
	Input: board = 
	[["5","3",".",".","7",".",".",".","."]
	,["6",".",".","1","9","5",".",".","."]
	,[".","9","8",".",".",".",".","6","."]
	,["8",".",".",".","6",".",".",".","3"]
	,["4",".",".","8",".","3",".",".","1"]
	,["7",".",".",".","2",".",".",".","6"]
	,[".","6",".",".",".",".","2","8","."]
	,[".",".",".","4","1","9",".",".","5"]
	,[".",".",".",".","8",".",".","7","9"]]
	Output: true
	
	Example 2:
	
	Input: board = 
	[["8","3",".",".","7",".",".",".","."]
	,["6",".",".","1","9","5",".",".","."]
	,[".","9","8",".",".",".",".","6","."]
	,["8",".",".",".","6",".",".",".","3"]
	,["4",".",".","8",".","3",".",".","1"]
	,["7",".",".",".","2",".",".",".","6"]
	,[".","6",".",".",".",".","2","8","."]
	,[".",".",".","4","1","9",".",".","5"]
	,[".",".",".",".","8",".",".","7","9"]]
	Output: false
	Explanation: Same as Example 1, except with the 5 in the top left corner being modified to 8. Since there are two 8's 
	in the top left 3x3 sub-box, it is invalid.
	 
	
	Constraints:
	
	board.length == 9
	board[i].length == 9
	board[i][j] is a digit 1-9 or '.'.
*/

package com.medium.problems;
import java.util.*;

public class Valid_Sudoku {
	public boolean isValidSudoku(char[][] board) {
        for(int i = 0; i < 9; i++){
            boolean bool = column(i, board);
            if(!bool)
                return false;
        }

        for(int i = 0; i < 9; i++){
            boolean bool = row(i, board);
            if(!bool)
                return false;
        }

        for(int i = 0; i < 9; i+=3){
            for(int j = 0; j < 9; j+=3){
                boolean bool = grid(i, j , board);
                if(!bool)
                    return false;
            }
        }

        return true;
    }

    boolean column(int j, char[][] board){
        HashSet<Character> hs = new HashSet<>();
        for(int i = 0; i < 9; i++){
            if(hs.contains(board[i][j]))
                return false;
            if(board[i][j] != '.')
                hs.add(board[i][j]);
        }
        return true;
    }

    boolean row(int i, char[][] board){
        HashSet<Character> hs = new HashSet<>();
        for(int j = 0; j< 9; j++){
            if(hs.contains(board[i][j]))
                return false;
            if(board[i][j] != '.')
                hs.add(board[i][j]);
        }
        return true;
    }

    boolean grid(int i, int j, char[][] board){
        HashSet<Character> hs = new HashSet<>();
        int temp = j;
        for(int k = 0; k < 3; k++){
            j = temp;
            for(int l = 0; l < 3; l++){
                if(hs.contains(board[i][j]))
                    return false;
                if(board[i][j] != '.')
                    hs.add(board[i][j]);
                j++;
            }
            i++;
        }
        return true;
    }
}
