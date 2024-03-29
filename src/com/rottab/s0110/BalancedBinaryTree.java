package com.rottab.s0110;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

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

public class BalancedBinaryTree {
    public int dfs(TreeNode root) {
        if (root == null) return 0;
        return Integer.max(dfs(root.left), dfs(root.right)) + 1;
    }

    public boolean isBalanced(TreeNode root) {
        if (root == null) return true;
        return Math.abs(dfs(root.left) - dfs(root.right)) <= 1 && isBalanced(root.left) && isBalanced(root.right);
    }

    @Test
    public void test() {
        assertThat(isBalanced(new TreeNode(3, new TreeNode(9, null, null),
                new TreeNode(20, new TreeNode(15, null, null), new TreeNode(7, null, null)))))
                .isTrue();
        assertThat(isBalanced(new TreeNode(1, new TreeNode(2, new TreeNode(3, new TreeNode(4, null, null), new TreeNode(4, null, null)
        ), new TreeNode(3, null, null)), new TreeNode(2, null, null)))).isFalse();
    }
}
