package com.sovanleetcode.hashmap;

import java.util.HashMap;
import java.util.Map;


/*
 * 3. Longest Substring Without Repeating Characters
Given a string, find the length of the longest substring without repeating characters.

Example 1:

Input: "abcabcbb"
Output: 3 
Explanation: The answer is "abc", with the length of 3. 
Example 2:

Input: "bbbbb"
Output: 1
Explanation: The answer is "b", with the length of 1.
Example 3:

Input: "pwwkew"
Output: 3
Explanation: The answer is "wke", with the length of 3. 
Note that the answer must be a substring, "pwke" is a subsequence and not a substring. 
 */

public class LongestUniqueSubstring {

	public int lengthOfLongestSubstring(String s) {

		int start = 0;
		int end = 0;
		char c = '\0';
		int prevIndex;
		Map<Character, Integer> charMap = new HashMap<Character, Integer>();
		int maxLength = Integer.MIN_VALUE;
		String longestSubstring = "";
		int currLength = 0;
		for (end = 0; end < s.length(); end++) {
			c = s.charAt(end);
			if (!charMap.containsKey(c)) {

				charMap.put(c, end);

			} else {
				prevIndex = charMap.get(c);
				if (prevIndex >= start) {
					start = prevIndex + 1;
				}
				charMap.put(c, end);
			}
			currLength = end - start + 1;
			if (currLength > maxLength) {

				maxLength = currLength;
				longestSubstring = s.substring(start, end + 1);

			}
		}
		if (maxLength == Integer.MIN_VALUE) {

			return 0;
		}
		System.out.println(longestSubstring);
		return maxLength;
	}
}
