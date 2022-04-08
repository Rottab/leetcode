package com.rottab.s0026;

import org.junit.jupiter.api.Test;

import java.util.Map;
import java.util.TreeMap;

public class RemoveDuplicatesFromSortedArray {
    public int removeDuplicates1(int[] nums) {
        int size = nums.length;
        if (size == 1) return size;

        int i = 0;
        while ((i != nums.length) && (i < size - 1) && (nums[i] <= nums[i + 1])) {
            if (nums[i] == nums[i + 1]) {
                for (int j = i + 1; j < size - 1; j++) {
                    int temp = nums[j];
                    nums[j] = nums[j + 1];
                    nums[j + 1] = temp;
                }
                size -= 1;
            } else i++;
        }
        return size;
    }

    @Test
    public void test11() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates1(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test12() {
        int[] nums = {0};
        int size = removeDuplicates1(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test13() {
        int[] nums = {4, 4};
        int size = removeDuplicates1(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }


    @Test
    public void test14() {
        int[] nums = {3, 3, 3, 3, 3, 3, 3};
        int size = removeDuplicates1(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test15() {
        int[] nums = {4, 5};
        int size = removeDuplicates1(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    public int removeDuplicates2(int[] nums) {
        Map<Integer, Boolean> map = new TreeMap<>();
        for (int i = 0; i < nums.length; i++) {
            map.put(nums[i], true);
        }
        int i = 0;
        for (Map.Entry<Integer, Boolean> entry : map.entrySet()) {
            nums[i] = entry.getKey();
            i++;
        }
        return map.size();
    }

    @Test
    public void test21() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates2(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test22() {
        int[] nums = {0};
        int size = removeDuplicates2(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test23() {
        int[] nums = {4, 4};
        int size = removeDuplicates2(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }


    @Test
    public void test24() {
        int[] nums = {3, 3, 3, 3, 3, 3, 3};
        int size = removeDuplicates2(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test25() {
        int[] nums = {4, 5};
        int size = removeDuplicates2(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }


    public int removeDuplicates3(int[] nums) {
        int size = 0;
        for (int i = 1; i < nums.length; i++) {
            if (nums[size] < nums[i]){
                size++;
                nums[size] = nums[i];
            }
        }
        return size + 1;
    }

    @Test
    public void test31() {
        int[] nums = {0, 0, 1, 1, 1, 2, 2, 3, 3, 4};
        int size = removeDuplicates3(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test32() {
        int[] nums = {0};
        int size = removeDuplicates3(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test33() {
        int[] nums = {4, 4};
        int size = removeDuplicates3(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }


    @Test
    public void test34() {
        int[] nums = {3, 3, 3, 3, 3, 3, 3};
        int size = removeDuplicates3(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }

    @Test
    public void test35() {
        int[] nums = {4, 5};
        int size = removeDuplicates3(nums);
        System.out.println("Start Size " + nums.length);
        System.out.println("End Size " + size);
        for (int i = 0; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
        }
        System.out.println("\n------");
    }
}
