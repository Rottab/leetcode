package com.rottab.s0112;

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

public class PathSum {

    public boolean hasPathSum(TreeNode root, int targetSum) {
        if (root == null) return false;
        else if (root.left == null && root.right == null && targetSum - root.val == 0) return true;
        else if (root.left != null && root.right == null) return hasPathSum(root.left, targetSum - root.val);
        else if (root.right != null && root.left == null) return hasPathSum(root.right, targetSum - root.val);
        return hasPathSum(root.left, targetSum - root.val) || hasPathSum(root.right, targetSum - root.val);
    }

    @Test
    public void test() {
        assertThat(hasPathSum(null, 0)).isFalse();
        assertThat(hasPathSum(new TreeNode(1, new TreeNode(2, null, null), null), 1))
                .isFalse();
        assertThat(hasPathSum(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                new TreeNode(4, null, null)),
                        null),
                6)).isTrue();
        assertThat(hasPathSum(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                new TreeNode(4, null, null)),
                        null),
                10)).isFalse();
        assertThat(hasPathSum(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                new TreeNode(4, null, null)),
                        null),
                7)).isTrue();
        assertThat(hasPathSum(new TreeNode(1,
                        new TreeNode(2,
                                new TreeNode(3, null, null),
                                new TreeNode(4, null, null)),
                        null),
                1)).isFalse();
    }
}
