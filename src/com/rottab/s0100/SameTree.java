package com.rottab.s0100;

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

public class SameTree {
    public boolean isSameTree(TreeNode p, TreeNode q) {
        if (p == null && q == null) return true;
        else if (p == null || q == null) return false;

        if (p.val == q.val) return isSameTree(p.left, q.left) && isSameTree(p.right, q.right);
        else return false;
    }

    @Test
    public void test() {
        assertThat(isSameTree(
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)),
                new TreeNode(1, new TreeNode(2, null, null), new TreeNode(3, null, null)))).isTrue();
    }
}
