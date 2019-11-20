package com.sovanleetcode.hashmap;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/*
 * 
 * 554. Brick Wall: https://leetcode.com/problems/brick-wall/
 * There is a brick wall in front of you. 
 * The wall is rectangular and has several rows of bricks. 
 * The bricks have the same height but different width. 
 * You want to draw a vertical line from the top to the bottom and cross the least bricks.
 * The brick wall is represented by a list of rows. 
 * Each row is a list of integers representing the width of each brick in this row from left to right.
 * If your line go through the edge of a brick, then the brick is not considered as crossed. You need to find out how to draw the line to cross the least bricks and return the number of crossed bricks.
 * You cannot draw a line just along one of the two vertical edges of the wall, 
 * in which case the line will obviously cross no bricks.
 * Example:
 * Input: 
  	[[1,2,2,1],
     [3,1,2],
     [1,3,2],
     [2,4],
     [3,1,2],
     [1,3,1,1]]
 *  Output: 2 
 */

public class PhankaInBrickWall {

	public int leastBricks(List<List<Integer>> wall) {

		Map<Integer, Integer> countMap = new HashMap<Integer, Integer>();
		int pos = 0;
		int maxColumnPhanka = Integer.MIN_VALUE;
		for (List<Integer> column : wall) {
			pos = 0;
			for (int i = 0; i < column.size() - 1; i++) {

				pos += column.get(i);
				int count = countMap.getOrDefault(pos, 0) + 1;
				countMap.put(pos, count);

				maxColumnPhanka = Math.max(maxColumnPhanka, count);

			}
		}

		if (maxColumnPhanka == Integer.MIN_VALUE) {
			return wall.size();
		}

		return wall.size() - maxColumnPhanka;

	}

}
