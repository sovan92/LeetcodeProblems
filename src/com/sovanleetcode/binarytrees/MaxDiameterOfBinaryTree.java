package com.sovanleetcode.binarytrees;
import com.sovanleetcode.entities.TreeNode;

/*
 
Given a binary tree, you need to compute the length of the diameter of the tree. 
The diameter of a binary tree is the length of the longest path between any two nodes in a tree.
This path may or may not pass through the root.

Example:
Given a binary tree
          1
         / \
        2   3
       / \     
      4   5    
Return 3, which is the length of the path [4,2,1,3] or [5,2,1,3].

Note: The length of path between two nodes is represented by the number of edges between them.

 Hint : Use the length of the Binary Tree . Then use that to compute the Diameter of the Binary Tree . 
*/

public class MaxDiameterOfBinaryTree {

	int maxDiameter = 0;

	public int diameterOfBinaryTree(TreeNode root) {

		int maxL = computeMaxDiameter(root);
		return maxDiameter;
	}

	public int computeMaxDiameter(TreeNode root) {
		if (root == null) {
			return 0;
		}

		int maxLeft = 0;
		int maxRight = 0;
		if (root.left != null) {
			maxLeft = 1 + computeMaxDiameter(root.left);
		}

		if (root.right != null) {
			maxRight = 1 + computeMaxDiameter(root.right);
		}

		int currentDiameter = maxLeft + maxRight;
		if (currentDiameter > maxDiameter) {
			maxDiameter = currentDiameter;
		}

		return Math.max(maxLeft, maxRight);

	}
}
