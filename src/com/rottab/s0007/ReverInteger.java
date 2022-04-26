package com.rottab.s0007;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ReverInteger {


    public int reverse(int x) {
        long reversed = 0;
        long num = Math.abs(x);
        while (num != 0) {
            reversed = reversed * 10 + num % 10;
            num = num / 10;
        }
        if (reversed > Integer.MAX_VALUE || reversed < Integer.MIN_VALUE) return 0;
        return (int) (x > 0 ? reversed : -reversed);
    }

    @Test
    public void test() {
        assertThat(reverse(1534236469)).isEqualTo(0);
        assertThat(reverse(123)).isEqualTo(321);
        assertThat(reverse(-123)).isEqualTo(-321);
    }
}
