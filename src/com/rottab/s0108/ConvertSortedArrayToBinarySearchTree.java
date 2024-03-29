package com.rottab.s0108;

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

public class ConvertSortedArrayToBinarySearchTree {
    public TreeNode sortedArrayToBST(int[] nums, int left, int right) {
        if (left > right) return null;
        int mid = (right - left) / 2 + left;
        return new TreeNode(nums[mid], sortedArrayToBST(nums, left, mid - 1), sortedArrayToBST(nums, mid + 1, right));
    }

    public TreeNode sortedArrayToBST(int[] nums) {
        return sortedArrayToBST(nums, 0, nums.length - 1);
    }

    @Test
    public void test() {
        sortedArrayToBST(new int[]{-10, -3, 0, 5, 9});
    }
}
