package com.rottab.s0219;

import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicate2 {
    public boolean containsNearbyDuplicate(int[] nums, int k) {
        for (int i = 0; i < nums.length; i++) {
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[i] == nums[j] && Math.abs(i - j) <= k) return true;
            }
        }
        return false;
    }

    public boolean containsNearbyDuplicate2(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(nums[i]) && Math.abs(i - map.get(nums[i])) <= k) return true;
            else map.put(nums[i], i);
        }
        return false;
    }

    @Test
    public void test() {
        assertTrue(containsNearbyDuplicate(new int[]{1, 2, 3, 1}, 3));
        assertTrue(containsNearbyDuplicate(new int[]{1, 0, 1, 1}, 1));
        assertFalse(containsNearbyDuplicate(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }

    @Test
    public void test2() {
        assertTrue(containsNearbyDuplicate2(new int[]{1, 2, 3, 1}, 3));
        assertTrue(containsNearbyDuplicate2(new int[]{1, 0, 1, 1}, 1));
        assertFalse(containsNearbyDuplicate2(new int[]{1, 2, 3, 1, 2, 3}, 2));
    }
}
