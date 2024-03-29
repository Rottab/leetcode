package com.rottab.s0069;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class SqrtX {
    public int mySqrt1(int x) {
        int c = 0;
        for (int i = 1; x > 0; i += 2) {
            if (x - i < 0) return c;
            x -= i;
            c++;
        }
        return c;
    }

    @Test
    public void test() {
        assertThat(mySqrt1(64)).isEqualTo(8);
        assertThat(mySqrt1(8)).isEqualTo(2);
    }

    public int mySqrt2(int x) {
        if (x == 0 || x == 1) return x;

        long left = 1;
        long right = x;

        while (left < right) {
            long mid = (long) (left + Math.floor((right - left) / 2));
            if (mid * mid == x) return (int) mid;
            else if (mid * mid > x) right = mid;
            else if (mid * mid < x) left = mid + 1;
        }
        return (int) left - 1;
    }

    @Test
    public void test2() {
        assertThat(mySqrt2(0)).isEqualTo(0);
        assertThat(mySqrt2(1)).isEqualTo(1);
        assertThat(mySqrt2(64)).isEqualTo(8);
        assertThat(mySqrt2(8)).isEqualTo(2);
        assertThat(mySqrt2(10)).isEqualTo(3);
        assertThat(mySqrt2(3)).isEqualTo(1);
        assertThat(mySqrt2(2147395599)).isEqualTo(46339);
    }
}
