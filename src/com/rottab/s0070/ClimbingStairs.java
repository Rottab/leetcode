package com.rottab.s0070;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ClimbingStairs {
    public int climbStairs(int n) {
        if (n == 1 || n == 0) return 1;
        int[] dp = new int[n + 1];
        dp[0] = 1;
        dp[1] = 1;
        for (int i = 1; i < n; i++) {
            dp[i + 1] = dp[i] + dp[i - 1];
        }
        return dp[n];
    }

    @Test
    public void test() {
        assertThat(climbStairs(1)).isEqualTo(1);
        assertThat(climbStairs(2)).isEqualTo(2);
        assertThat(climbStairs(3)).isEqualTo(3);
        assertThat(climbStairs(5)).isEqualTo(8);
    }
}
