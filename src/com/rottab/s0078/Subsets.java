package com.rottab.s0078;

import org.junit.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class Subsets {


    public void _subsets(int[] nums, LinkedList<Integer> subset, int i, LinkedList<List<Integer>> result) {
        if (i == nums.length) {
            result.add(new ArrayList<>(subset));
            return;
        }
        // Not add the value
        _subsets(nums, subset, i + 1, result);
        // Add the value
        LinkedList<Integer> sub = new LinkedList<>(subset);
        sub.add(nums[i]);
        _subsets(nums, sub, i + 1, result);
    }

    public List<List<Integer>> subsets(int[] nums) {
        LinkedList<List<Integer>> result = new LinkedList<>();
        _subsets(nums, new LinkedList<>(), 0, result);
        return result;
    }

    @Test
    public void test() {
        System.out.println(subsets(new int[]{1, 2, 3}));
        System.out.println(subsets(new int[]{1}));
    }
}
