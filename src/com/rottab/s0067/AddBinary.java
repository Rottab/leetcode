package com.rottab.s0067;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class AddBinary {
    public String addBinary(String a, String b) {
        StringBuilder builder = new StringBuilder();
        int sa = a.length() - 1;
        int sb = b.length() - 1;
        int carry = 0;
        while (sa >= 0 && sb >= 0) {
            int i1 = Integer.parseInt(String.valueOf(a.charAt(sa)));
            int i2 = Integer.parseInt(String.valueOf(b.charAt(sb)));
            int result = i1 + i2 + carry;
            if (result == 2) {
                result = 0;
                carry = 1;
            } else if (result == 3) {
                result = 1;
                carry = 1;
            } else carry = 0;
            sa--;
            sb--;
            builder.insert(0, result);
        }
        while (sa >= 0) {
            int i1 = Integer.parseInt(String.valueOf(a.charAt(sa)));
            int result = i1 + carry;
            if (result == 2) {
                result = 0;
                carry = 1;
            } else if (result == 3) {
                result = 1;
                carry = 1;
            } else carry = 0;
            sa--;
            builder.insert(0, result);
        }
        while (sb >= 0) {
            int i2 = Integer.parseInt(String.valueOf(b.charAt(sb)));
            int result = i2 + carry;
            if (result == 2) {
                result = 0;
                carry = 1;
            } else if (result == 3) {
                result = 1;
                carry = 1;
            } else carry = 0;
            sb--;
            builder.insert(0, result);
        }
        if (carry != 0) builder.insert(0, carry);
        return builder.toString();
    }

    @Test
    public void test() {
        assertThat(addBinary("11", "1")).isEqualTo("100");
        assertThat(addBinary("1010", "1011")).isEqualTo("10101");
        assertThat(addBinary("1", "100")).isEqualTo("101");
        assertThat(addBinary("1111", "1111")).isEqualTo("11110");
    }
}
