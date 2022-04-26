package com.rottab.s0222;

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

public class CountCompleteTreeNodes {
    public int countNodesLinear(TreeNode root) {
        if (root == null) return 0;
        return countNodesLinear(root.left) + countNodesLinear(root.right) + 1;
    }

    public int getHeight(TreeNode root) {
        if (root == null) return 0;
        return 1 + getHeight(root.left);
    }

    public int countNodes(TreeNode root) {
        if (root == null) return 0;
        int leftHeight = getHeight(root.left);
        int rightHeight = getHeight(root.right);
        if (leftHeight == rightHeight) return (1 << leftHeight) + countNodes(root.right);
        return (1 << rightHeight) + countNodes(root.left);
    }

    @Test
    public void test() {
        assertThat(countNodes(
                null
        )).isEqualTo(0);
        assertThat(countNodesLinear(
                new TreeNode(1, null, null)
        )).isEqualTo(1);
        assertThat(countNodesLinear(
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null))
        )).isEqualTo(3);
        assertThat(countNodesLinear(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), null),
                        new TreeNode(3, null, null))
        )).isEqualTo(4);
        assertThat(countNodesLinear(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                        new TreeNode(3, null, null))
        )).isEqualTo(5);
        assertThat(countNodesLinear(
                new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(5, null, null)),
                        new TreeNode(3, new TreeNode(6, null, null), null))
        )).isEqualTo(6);
    }
}
