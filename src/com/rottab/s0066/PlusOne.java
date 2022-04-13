package com.rottab.s0066;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class PlusOne {
    public int[] plusOne(int[] digits) {
        int carry = 1;
        for (int i = digits.length - 1; i >= 0 && carry != 0; i--) {
            if (++digits[i] == 10) {
                digits[i] = 0;
                carry = 1;
            } else carry = 0;
        }
        if (carry > 0) {
            int[] ints = new int[digits.length + 1];
            ints[0] = carry;
            for (int i = 1; i < ints.length; i++) ints[i] = 0;
            return ints;
        }
        return digits;
    }

    @Test
    public void test() {
        assertThat(plusOne(new int[]{1, 2, 3})).containsExactly(1, 2, 4);
        assertThat(plusOne(new int[]{1, 2, 9})).containsExactly(1, 3, 0);
        assertThat(plusOne(new int[]{9, 9, 9})).containsExactly(1, 0, 0, 0);
    }
}
