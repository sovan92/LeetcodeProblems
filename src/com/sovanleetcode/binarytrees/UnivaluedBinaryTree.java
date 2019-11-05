package com.sovanleetcode.binarytrees;

import com.sovanleetcode.entities.TreeNode;

class UnivaluedBinaryTree {

	int value = -1;

	public boolean isUnivalTree(TreeNode root) {

		if (root == null) {
			return true;
		}
		value = root.val;

		return isUnivalTreeDfs(root, value);
	}

	public boolean isUnivalTreeDfs(TreeNode root, int val) {

		if (root == null) {
			return true;
		}
		boolean isRootOk = (root.val == val);
		boolean isLeftOk = isUnivalTreeDfs(root.left, val);
		boolean isRightOk = isUnivalTreeDfs(root.right, val);

		return isRootOk && isLeftOk && isRightOk;
	}
}