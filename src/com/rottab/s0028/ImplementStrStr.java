package com.rottab.s0028;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class ImplementStrStr {
    public int strStr(String haystack, String needle) {
        if (needle.isEmpty()) return 0;
        if (needle.length() > haystack.length()) return -1;
        int index = 0;
        for (int i = 0; i < haystack.length(); i++) {
            if (haystack.charAt(i) == needle.charAt(0)) {
                index = i;
                int k = 0;
                for (int j = i; j < haystack.length() && k < needle.length(); j++, k++) {
                    if (haystack.charAt(j) != needle.charAt(k)) break;
                }
                if (k == needle.length()) return index;
            }
        }
        return -1;
    }

    @Test
    public void test() {
        assertThat(strStr("food", "")).isEqualTo(0);
        assertThat(strStr("hello", "ll")).isEqualTo(2);
        assertThat(strStr("aaaaa", "bba")).isEqualTo(-1);
        assertThat(strStr("aa", "aaa")).isEqualTo(-1);
    }
}
