package com.rottab.s0053;

import org.junit.Test;

import static java.lang.Math.max;
import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MaximumSubarray {
    public int maxSubArray(int[] nums) {
        int max = nums[0];
        int prefix = 0;
        for (int num : nums) {
            if (prefix < 0) prefix = 0;
            prefix += num;
            max = max(max, prefix);
        }
        return max;
    }

    @Test
    public void test() {
        assertThat(maxSubArray(new int[]{-2, 1, -3, 4, -1, 2, 1, -5, 4})).isEqualTo(6);
        assertThat(maxSubArray(new int[]{1})).isEqualTo(1);
        assertThat(maxSubArray(new int[]{5, 4, -1, 7, 8})).isEqualTo(23);
        assertThat(maxSubArray(new int[]{-1, 0, -2})).isEqualTo(0);
    }
}
