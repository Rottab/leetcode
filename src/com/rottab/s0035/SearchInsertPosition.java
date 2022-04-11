package com.rottab.s0035;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SearchInsertPosition {
    public int searchInsert(int[] nums, int target) {
        if (nums.length == 0) return 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] == target || nums[i] > target) return i;
        }
        return nums.length;
    }

    @Test
    public void test() {
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 5)).isEqualTo(2);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 2)).isEqualTo(1);
        assertThat(searchInsert(new int[]{1, 3, 5, 6}, 7)).isEqualTo(4);
        assertThat(searchInsert(new int[]{}, 7)).isEqualTo(0);
    }
}
