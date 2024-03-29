package com.rottab.s0045;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JumpGame2 {
    // DP solution, not optimal cause it's n^2
    public int jump1(int[] nums) {
        int[] dp = new int[nums.length];
        dp[0] = 0;
        for (int i = 1; i < nums.length; i++) {
            dp[i] = Integer.MAX_VALUE;
            for (int j = i - 1; j >= 0; j--) {
                if (nums[j] >= i - j) dp[i] = Integer.min(dp[j] + 1, dp[i]);
            }
        }
        return dp[dp.length - 1];
    }

    @Test
    public void test1() {
        assertThat(jump1(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(jump1(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
        assertThat(jump1(new int[]{1, 2})).isEqualTo(1);
    }

    // Greedy solution
    public int jump2(int[] nums) {
        int left = 0;
        int right = 0;
        int jumps = 0;
        while (right < nums.length - 1) {
            int max = 0;
            for (int i = left; i < right + 1; i++) {
                max = Integer.max(max, i + nums[i]);
            }
            left = right;
            right = max;
            jumps++;
        }
        return jumps;
    }

    @Test
    public void test2() {
        assertThat(jump2(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(jump2(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
        assertThat(jump2(new int[]{1, 2})).isEqualTo(1);
    }

}
