package com.rottab.s0111;

import com.sun.source.tree.Tree;
import org.junit.jupiter.api.Test;

import java.util.LinkedList;
import java.util.Queue;

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

    public int minDepth1(TreeNode root, int depth) {
        if (root.left == null && root.right == null) return depth + 1;
        else if (root.left == null) return minDepth1(root.right, depth + 1);
        else if (root.right == null) return minDepth1(root.left, depth + 1);
        return Integer.min(minDepth1(root.left, depth + 1), minDepth1(root.right, depth + 1));
    }

    public int minDepth1(TreeNode root) {
        if (root == null) return 0;
        return minDepth1(root, 0);
    }

    @Test
    public void test1() {
        assertThat(minDepth1(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null)))
        )).isEqualTo(2);
        assertThat(minDepth1(
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)))
        )).isEqualTo(3);

        assertThat(minDepth1(null)).isEqualTo(0);
    }


    public int minDepth2(TreeNode root) {
        if (root == null) return 0;
        Queue<TreeNode> queue = new LinkedList<>();
        queue.add(root);
        int depth = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                TreeNode treeNode = queue.remove();
                if (treeNode.left == null && treeNode.right == null) return ++depth;
                if (treeNode.left != null) queue.add(treeNode.left);
                if (treeNode.right != null) queue.add(treeNode.right);
            }
            depth++;
        }
        return depth;
    }

    @Test
    public void test2() {
        assertThat(minDepth2(
                new TreeNode(3, new TreeNode(9, null, null),
                        new TreeNode(20, new TreeNode(15, null, null),
                                new TreeNode(7, null, null)))
        )).isEqualTo(2);
        assertThat(minDepth2(
                new TreeNode(1, null, new TreeNode(2, null, new TreeNode(3, null, null)))
        )).isEqualTo(3);

        assertThat(minDepth2(null)).isEqualTo(0);
    }
}
