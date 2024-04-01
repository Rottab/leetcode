package com.rottab.s0015;

import org.junit.Test;

import java.util.*;

public class ThreeSum {

    public static List<List<Integer>> threeSum(int[] nums) {
        Set<List<Integer>> result = new HashSet<>();
        Arrays.sort(nums);
        for (int a = 0; a < nums.length; a++) {
            if (a > 0 && nums[a] == nums[a - 1]) continue;
            int l = a + 1;
            int r = nums.length - 1;
            while (l < r) {
                int sum = nums[a] + nums[l] + nums[r];
                if (sum > 0) r = r - 1;
                else if (sum < 0) l = l + 1;
                else {
                    result.add(List.of(nums[a], nums[l], nums[r]));
                    if (nums[l] != nums[l + 1]) l++;
                    else {
                        while (l < r && nums[l] == nums[l + 1]) l++;
                    }
                }
            }
        }
        return result.stream().toList();
    }

    @Test
    public void test() {
        List<List<Integer>> lists = threeSum(new int[]{-1, 0, 1, 2, -1, -4});
        System.out.println(lists);
    }
}
