package com.rottab.s0027;

import org.junit.jupiter.api.Test;

public class RemoveElement {
    public int removeElement(int[] nums, int val) {
        int j = 0;
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != val) nums[j++] = nums[i];
        }
        return j;
    }

    @Test
    public void test1() {
        int[] nums = {3, 2, 2, 3};
        int val = 3;
        int s = removeElement(nums, val);
        for (int i = 0; i < s; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test2() {
        int[] nums = {0, 1, 2, 2, 3, 0, 4, 2};
        int val = 2;
        int s = removeElement(nums, val);
        for (int i = 0; i < s; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test3() {
        int[] nums = {3, 3, 3, 3, 3};
        int val = 3;
        int s = removeElement(nums, val);
        for (int i = 0; i < s; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }

    @Test
    public void test4() {
        int[] nums = {1, 2};
        int val = 2;
        int s = removeElement(nums, val);
        for (int i = 0; i < s; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println();
    }
}
