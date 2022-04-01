package com.rottab.s0001;

import org.junit.Test;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.IntStream;


public class TwoSum {

    public static int[] twoSum(int[] arr, int target) {
        Map<Integer, Integer> map = new HashMap<>();
        IntStream.range(0, arr.length).forEach(i -> map.put(arr[i], i));
        for (int i = 0; i < arr.length; i++) {
            int key = target - arr[i];
            if (map.containsKey(key) && map.get(key) != i) {
                return new int[]{i, map.get(key)};
            }
        }
        return new int[0];
    }

    @Test
    public void test() {
        assert Arrays.equals(twoSum(new int[]{2, 7, 11, 15}, 9), new int[]{0, 1});
        assert Arrays.equals(twoSum(new int[]{3, 2, 4}, 6), new int[]{1, 2});
        assert Arrays.equals(twoSum(new int[]{3, 3}, 6), new int[]{0, 1});
    }

}
