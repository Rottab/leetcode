package com.rottab.s0101;

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

public class SymmetricTree {

    public boolean isSymmetric(TreeNode left, TreeNode right) {
        if (left == null && right == null) return true;
        else if (left == null || right == null) return false;

        if (left.val != right.val) return false;
        return isSymmetric(left.left, right.right) && isSymmetric(left.right, right.left);
    }

    public boolean isSymmetric(TreeNode root) {
        if (root == null) return false;
        return isSymmetric(root.left, root.right);
    }

    @Test
    public void test() {
        assertThat(isSymmetric(new TreeNode(1, new TreeNode(2, new TreeNode(4, null, null), new TreeNode(3, null, null)),
                new TreeNode(2, new TreeNode(3, null, null), new TreeNode(4, null, null))))).isTrue();
    }
}
