package com.rottab.s0088;

import org.junit.Test;

import static org.assertj.core.api.AssertionsForClassTypes.assertThat;

public class MergeSortedArray {
    public void merge(int[] nums1, int m, int[] nums2, int n) {
        if (n == 0) return;
        int i = m + n - 1;
        m--;
        n--;
        for (; n >= 0 && m >= 0; i--) {
            if (nums1[m] > nums2[n]) nums1[i] = nums1[m--];
            else nums1[i] = nums2[n--];
        }
        while (n >= 0) nums1[i--] = nums2[n--];
    }

    @Test
    public void test() {
        int[] nums1 = {1, 2, 3, 0, 0, 0};
        merge(nums1, 3, new int[]{2, 5, 6}, 3);
        assertThat(nums1).containsExactly(1, 2, 2, 3, 5, 6);

        int[] nums2 = {1};
        merge(nums2, 1, new int[]{}, 0);
        assertThat(nums2).containsExactly(1);

        int[] nums3 = {0};
        merge(nums3, 0, new int[]{1}, 1);
        assertThat(nums3).containsExactly(1);

        int[] nums4 = {1, 3, 5, 0, 0, 0};
        merge(nums4, 3, new int[]{1, 2, 4}, 3);
        assertThat(nums4).containsExactly(1, 1, 2, 3, 4, 5);

        int[] nums5 = {1, 2, 4, 5, 6, 0};
        merge(nums5, 5, new int[]{3}, 1);
        assertThat(nums5).containsExactly(1, 2, 3, 4, 5, 6);
    }
}
