package ru.job4j.algo;

import java.util.Arrays;

public class SmallestRangeFinder {

    public static int[] findSmallestRange(int[] nums, int k) {
        int left = 0;
        int right = 1;
        int index = 0;
        int length = 2;
        int[] rsl = new int[length];
        int first = 0;
        int elements = 1;
        while (right < nums.length) {
            if (nums[left] != nums[right] && k == elements) {
                rsl[index++] = first;
                rsl[index] = first + elements - 1;
            }
            if (nums[left] == nums[right]) {
                first = right;
                elements = 1;
            }
            left++;
            right++;
            elements++;
        }
        return rsl[1] != 0 ? rsl : null;
    }

    public static void main(String[] args) {
        int[] nums = {1, 2, 3, 3, 5, 6, 7};
        int k = 4;
        int[] result = findSmallestRange(nums, k);
        if (result != null) {
            System.out.println("Наименьший диапазон с " + k + " различными элементами: " + Arrays.toString(result));
        } else {
            System.out.println("Такой диапазон не существует");
        }

        int[] nums2 = {1, 3, 5, 7, 9};
        int k2 = 3;
        int[] result2 = findSmallestRange(nums2, k2);
        if (result2 != null) {
            System.out.println("Наименьший диапазон с " + k2 + " различными элементами: " + Arrays.toString(result2));
        } else {
            System.out.println("Такой диапазон не существует");
        }

        int[] nums3 = {1, 1, 3, 5, 7, 9};
        int k3 = 3;
        int[] result3 = findSmallestRange(nums3, k3);
        if (result2 != null) {
            System.out.println("Наименьший диапазон с " + k3 + " различными элементами: " + Arrays.toString(result3));
        } else {
            System.out.println("Такой диапазон не существует");
        }
    }
}
