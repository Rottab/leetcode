package com.rottab.s0094;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

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

public class BinaryTreeInorderTraversal {

    void inOrder(TreeNode head, List<Integer> list) {
        if (head == null) return;
        inOrder(head.left, list);
        list.add(head.val);
        inOrder(head.right, list);
    }

    public List<Integer> inorderTraversal(TreeNode root) {
        List<Integer> list = new ArrayList<>();
        inOrder(root, list);
        return list;
    }

    @Test
    public void test() {
        assertThat(inorderTraversal(new TreeNode(1, null, new TreeNode(2, new TreeNode(3, null, null), null))))
                .isEqualTo(List.of(1, 3, 2));
    }

}
