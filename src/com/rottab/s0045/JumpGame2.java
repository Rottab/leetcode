package com.rottab.s0045;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class JumpGame2 {
    // DP solution, not optimal cause it's n^2
    public int jump(int[] nums) {
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
    public void test() {
        assertThat(jump(new int[]{2, 3, 1, 1, 4})).isEqualTo(2);
        assertThat(jump(new int[]{2, 3, 0, 1, 4})).isEqualTo(2);
        assertThat(jump(new int[]{1, 2})).isEqualTo(1);
    }

}
