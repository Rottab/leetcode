package com.rottab.s0050;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PowXN {

    public double pow(double x, int n) {
        if (n == 0) return 1;
        if (n == 1) return x;
        double half = pow(x * x, n / 2);
        if (n % 2 == 0) return half;
        else return half * x;
    }

    public double myPow(double x, int n) {
        if (n < 0) {
            n = -n;
            x = 1 / x;
        }
        return Math.round(pow(x, n) * 100000d) / 100000d;
    }

    @Test
    public void test() {
        assertThat(myPow(2, 1)).isEqualTo(2);
        assertThat(myPow(2, 0)).isEqualTo(1);
        assertThat(myPow(2, 2)).isEqualTo(4);
        assertThat(myPow(2, -2)).isEqualTo(0.25);
        assertThat(myPow(2.1, 3)).isEqualTo(9.26100);
        assertThat(myPow(0.44528, 0)).isEqualTo(1);
        assertThat(myPow(0.44894, -5)).isEqualTo(54.83508);
    }
}
