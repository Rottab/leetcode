package com.rottab.s0347;

import org.junit.Test;

import java.util.*;

public class TopKFrequentElements {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = nums.length - 1; i >= 0; i--) {
            if (map.containsKey(nums[i])) map.put(nums[i], map.get(nums[i]) + 1);
            else map.put(nums[i], 1);
        }
        List<Map.Entry<Integer, Integer>> collect = map.entrySet().stream().sorted(Collections.reverseOrder(Map.Entry.comparingByValue())).toList();
        int[] res = new int[k];
        for (int i = 0; i < k; i++) res[i] = collect.get(i).getKey();
        return res;
    }

    @Test
    public void test() {
        assert Arrays.equals(topKFrequent(new int[]{1, 1, 1, 2, 2, 3}, 2), new int[]{1, 2});
        assert Arrays.equals(topKFrequent(new int[]{1}, 1), new int[]{1});
        assert Arrays.equals(topKFrequent(new int[]{-1, -1}, 1), new int[]{-1});

    }

}
