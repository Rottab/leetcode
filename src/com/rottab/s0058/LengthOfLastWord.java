package com.rottab.s0058;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LengthOfLastWord {
    public int lengthOfLastWord1(String s) {
        int size = 0;
        boolean space = false;
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != ' ') {
                if (space) size = 0;
                size++;
                space = false;
            } else {
                space = true;
            }
        }
        return size;
    }

    @Test
    public void test1() {
        assertThat(lengthOfLastWord1("Hello world")).isEqualTo(5);
        assertThat(lengthOfLastWord1("Hello world ")).isEqualTo(5);
        assertThat(lengthOfLastWord1("Hello ")).isEqualTo(5);
        assertThat(lengthOfLastWord1("  Hello ")).isEqualTo(5);
    }

    public int lengthOfLastWord2(String s) {
        int i = s.length() - 1;
        int size = 0;
        while (s.charAt(i) == ' ') i--;
        while (i != -1 && s.charAt(i) != ' ') {
            i--;
            size++;
        }
        return size;
    }

    @Test
    public void test2() {
        assertThat(lengthOfLastWord2("Hello world")).isEqualTo(5);
        assertThat(lengthOfLastWord2("Hello world ")).isEqualTo(5);
        assertThat(lengthOfLastWord2("Hello ")).isEqualTo(5);
        assertThat(lengthOfLastWord2("  Hello ")).isEqualTo(5);
    }
}
