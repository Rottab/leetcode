package com.rottab.s0222;

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

public class CountCompleteTreeNodes {
    public int countNodesLinear(TreeNode root) {
        if (root == null) return 0;
        return countNodesLinear(root.left) + countNodesLinear(root.right) + 1;
    }

    public int leftDepth(TreeNode root) {
        if (root == null) return 1;
        return leftDepth(root.left) + 1;
    }

    public int rightDepth(TreeNode root) {
        if (root == null) return 1;
        return rightDepth(root.right) + 1;
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = leftDepth(root.left);
        int rightHeight = rightDepth(root.right);
        if (leftHeight == rightHeight) return (1 << leftHeight) - 1;
        return countNodes(root.left) + countNodes(root.right) + 1;
    }

    @Test
    public void test() {
        assertThat(countNodes(
                null
        )).isEqualTo(0);
        assertThat(countNodes(
                new TreeNode(1, null, null)
        )).isEqualTo(1);
        assertThat(countNodes(
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null))
        )).isEqualTo(3);
        assertThat(countNodes(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                        new TreeNode(3, null, null))
        )).isEqualTo(4);
        assertThat(countNodes(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                        new TreeNode(3, null, null))
        )).isEqualTo(5);
        assertThat(countNodes(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                        new TreeNode(3, new TreeNode(6, null, null), null))
        )).isEqualTo(6);
    }
}
