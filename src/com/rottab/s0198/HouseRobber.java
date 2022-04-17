package com.rottab.s0198;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.stream.IntStream;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class HouseRobber {
    public int rob(int[] nums) {
        int[] dp = IntStream.concat(Arrays.stream(new int[]{0, 0}), Arrays.stream(nums)).toArray();
        for (int i = 2; i < dp.length; i++) dp[i] = Integer.max(dp[i - 2] + dp[i], dp[i - 1]);
        return dp[dp.length - 1];
    }

    @Test
    public void test() {
        assertThat(rob(new int[]{1, 2, 3, 1})).isEqualTo(4);
        assertThat(rob(new int[]{2, 7, 9, 3, 1})).isEqualTo(12);
        assertThat(rob(new int[]{2})).isEqualTo(2);
        assertThat(rob(new int[]{2, 1, 1, 2})).isEqualTo(4);
    }
}
