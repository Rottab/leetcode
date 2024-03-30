package com.rottab.s0704;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BinarySearch {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            int mid = (right - left) / 2 + left;
            if (nums[mid] < target) left = mid + 1;
            else if (nums[mid] > target) right = mid - 1;
            else return mid;
        }
        return -1;
    }

    @Test
    public void test() {
        assertEquals(4, search(new int[]{-1, 0, 3, 5, 9, 12}, 9));
        assertEquals(-1, search(new int[]{-1, 0, 3, 5, 9, 12}, 2));
    }
}
