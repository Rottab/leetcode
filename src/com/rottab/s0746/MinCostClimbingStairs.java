package com.rottab.s0746;

import org.junit.Test;

import java.util.Arrays;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MinCostClimbingStairs {
    public int minCostClimbingStairs(int[] cost) {
        int[] dp = Arrays.copyOf(cost, cost.length + 1);
        dp[cost.length] = 0;
        for (int i = dp.length - 3; i >= 0; i--) dp[i] += Integer.min(dp[i + 1], dp[i + 2]);
        return Integer.min(dp[0], dp[1]);
    }

    @Test
    public void test() {
        assertThat(minCostClimbingStairs(new int[]{10, 15, 20})).isEqualTo(15);
        assertThat(minCostClimbingStairs(new int[]{1, 100, 1, 1, 1, 100, 1, 1, 100, 1})).isEqualTo(6);
    }
}
