package com.rottab.s0226;

import org.junit.Test;

class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }
}

public class InvertBinaryTree {
    public TreeNode invertTree(TreeNode root) {
        if (root == null) return null;
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = invertTree(temp);
        return root;
    }

    @Test
    public void test() {
        invertTree(new TreeNode(2, new TreeNode(1, null, null), new TreeNode(3, null, null)));
    }
}
