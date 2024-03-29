package com.rottab.s0217;

import org.junit.Test;

import java.util.HashSet;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class ContainsDuplicate {

    public boolean containsDuplicate(int[] nums) {
        HashSet<Integer> map = new HashSet<>();
        for (int num : nums) {
            if (map.contains(num)) return true;
            else map.add(num);
        }
        return false;
    }


    @Test
    public void testValid() {
        assertTrue(containsDuplicate(new int[]{1, 2, 3, 1}));
        assertFalse(containsDuplicate(new int[]{1, 2, 3, 4}));
    }
}
