// https://leetcode.com/problems/image-overlap/description/

/*
	You are given two images, img1 and img2, represented as binary, square matrices of size n x n. A binary matrix has only 0s and 1s as values.
	
	We translate one image however we choose by sliding all the 1 bits left, right, up, and/or down any number of units. 
	We then place it on top of the other image. We can then calculate the overlap by counting the number of positions 
	that have a 1 in both images.
	
	Note also that a translation does not include any kind of rotation. Any 1 bits that are translated outside of the matrix borders are erased.
	
	Return the largest possible overlap.
	
	 
	Example 1:
	
	
	Input: img1 = [[1,1,0],[0,1,0],[0,1,0]], img2 = [[0,0,0],[0,1,1],[0,0,1]]
	Output: 3
	Explanation: We translate img1 to right by 1 unit and down by 1 unit.
	
	The number of positions that have a 1 in both images is 3 (shown in red).
	
	Example 2:
	
	Input: img1 = [[1]], img2 = [[1]]
	Output: 1
	
	Example 3:
	
	Input: img1 = [[0]], img2 = [[0]]
	Output: 0
	 
	
	Constraints:
	
	n == img1.length == img1[i].length
	n == img2.length == img2[i].length
	1 <= n <= 30
	img1[i][j] is either 0 or 1.
	img2[i][j] is either 0 or 1.
*/

package com.medium.problems;
import java.util.*;

public class Image_Overlap {
	public int largestOverlap(int[][] img1, int[][] img2) {
        ArrayList<ArrayList<Integer>> hm1 = new ArrayList<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> hm2 = new ArrayList<ArrayList<Integer>>();
        HashMap<Integer,Integer> hm3 = new HashMap<>();

        for(int i = 0; i < img1.length; i++)
            for(int j = 0; j < img1[0].length; j++)
                if(img1[i][j] == 1)
                    hm1.add(new ArrayList<Integer>(List.of(i+1,j+1)));

        for(int i = 0; i < img2.length; i++)
            for(int j = 0; j < img2[0].length; j++)
                if(img2[i][j] == 1)
                    hm2.add(new ArrayList<Integer>(List.of(i+1,j+1)));

        for(ArrayList list1 : hm1)
            for(ArrayList list2 : hm2){
                int numbers = ((int)list2.get(0) - (int)list1.get(0))*1000 + (int)list2.get(1) - (int)list1.get(1);
                hm3.put(numbers, hm3.getOrDefault(numbers,0)+1);
            }
        
        int max = 0;

        for(Map.Entry entry : hm3.entrySet())
            max = Math.max((int)entry.getValue(), max);

        return max;
    }
}
