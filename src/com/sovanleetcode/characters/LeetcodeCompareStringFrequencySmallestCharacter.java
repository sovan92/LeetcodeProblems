package com.sovanleetcode.characters;

import java.util.Arrays;

// 1170. Compare Strings by Frequency of the Smallest Character

/*
 * Let's define a function f(s) over a non-empty string s, 
 * which calculates the frequency of the smallest character in s. 
 * For example, if s = "dcce" then f(s) = 2 because the smallest character is "c" and its frequency is 2.
 * Now, given string arrays queries and words, 
 * return an integer array answer, where each answer[i] is the number of words such that f(queries[i]) < f(W), 
 * where W is a word in words. 
 */



public class LeetcodeCompareStringFrequencySmallestCharacter {

	 public int[] numSmallerByFrequency(String[] queries, String[] words) {
	        
	        int [] left = new int[queries.length];
	        int [] right = new int[words.length];
	        for(int i = 0;i< queries.length;i++){
	            left[i] = f(queries[i]);
	        }
	        
	        for(int i = 0;i< words.length;i++){
	            right[i] = f(words[i]);
	        }
	        
	        Arrays.sort(right);
	       
	        int [] answers = new int[left.length];
	        int ptr = 0;
	        for(int i = 0;i< left.length;i++){
	            
	            ptr = right.length-1;
	            while((ptr>=0) && (right[ptr] > left[i])){
	                answers[i]++;
	                ptr--;
	            }
	        }
	        return answers;
	    }
	    public int f(String x){
	        
	        char minChar = 'z';
	        int minCount = 0;
	        for(int i =0;i< x.length();i++){
	            
	            if((x.charAt(i) - 'a') < (minChar - 'a')){
	                minChar = x.charAt(i);
	                minCount = 1;
	            }
	            else if((x.charAt(i) - 'a') == (minChar - 'a')){
	                minCount++;
	            }
	        }
	        return minCount;
	        
	    }
	
	
	
}
