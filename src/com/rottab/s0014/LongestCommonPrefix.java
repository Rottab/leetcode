package com.rottab.s0014;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class LongestCommonPrefix {
    public String longestCommonPrefix(String[] strs) {
        StringBuilder result = new StringBuilder();
        int min = Integer.MAX_VALUE;
        for (String str : strs) {
            min = Math.min(min, str.length());
        }
        if (min == 0) return result.toString();
        for (int i = 0; i < min; i++) {
            for (int j = 1; j < strs.length; j++) {
                if (strs[j].charAt(i) != strs[j - 1].charAt(i)) return result.toString();
            }
            result.append(strs[0].charAt(i));
        }
        return result.toString();
    }

    @Test
    public void test() {
        assertThat(longestCommonPrefix(new String[]{"dog", "racecar", "car"})).isEqualTo("");
        assertThat(longestCommonPrefix(new String[]{"flower", "flow", "flight"})).isEqualTo("fl");
        assertThat(longestCommonPrefix(new String[]{"", "b"})).isEqualTo("");
        assertThat(longestCommonPrefix(new String[]{"a"})).isEqualTo("a");
    }
}
