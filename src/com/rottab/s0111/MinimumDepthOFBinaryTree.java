package com.rottab.s0111;

import org.junit.jupiter.api.Test;

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

public class MinimumDepthOFBinaryTree {

    public int minDepth(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return depth + 1;
        else if (root.left == null) return minDepth(root.right, depth + 1);
        else if (root.right == null) return minDepth(root.left, depth + 1);
        return Integer.min(minDepth(root.left, depth + 1), minDepth(root.right, depth + 1));
    }

    public int minDepth(TreeNode root) {
        if (root == null) return 0;
        return minDepth(root, 0);
    }

    @Test
    public void test() {
        assertThat(minDepth(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null)))
        )).isEqualTo(2);
        assertThat(minDepth(
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)))
        )).isEqualTo(3);

        assertThat(minDepth(null)).isEqualTo(0);
    }
}
