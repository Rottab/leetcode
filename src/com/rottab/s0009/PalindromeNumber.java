package com.rottab.s0009;

import org.junit.jupiter.api.Test;

import static java.lang.Math.abs;

public class PalindromeNumber {

    public boolean isPalindrome(int x) {
        int current = x;
        int reverse = 0;
        int remainder = 0;
        while (current != 0) {
            remainder = current % 10;
            reverse = reverse * 10 + remainder;
            current = current / 10;
        }
        return abs(reverse) == x;
    }


    @Test
    public void test() {
        assert isPalindrome(121);
        assert !isPalindrome(-121);
        assert !isPalindrome(1231);
        assert isPalindrome(1221);
    }
}
