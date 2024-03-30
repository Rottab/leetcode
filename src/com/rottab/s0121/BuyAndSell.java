package com.rottab.s0121;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BuyAndSell {

    public static int maxProfit(int[] prices) {
        int max = 0;
        int left = 0;
        int right = 1;
        while (right < prices.length) {
            if (prices[left] < prices[right]) {
                int profit = prices[right] - prices[left];
                max = Math.max(profit, max);
            } else left = right;
            right++;
        }
        return max;
    }


    @Test
    public void test() {
        assertEquals(5, maxProfit(new int[]{7, 1, 5, 3, 6, 4}));
    }
}
