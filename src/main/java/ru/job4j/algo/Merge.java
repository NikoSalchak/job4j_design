package ru.job4j.algo;

import java.util.Arrays;

public class Merge {

    public static int[] mergeSort(int[] array) {
        int[] result = array;
        int n = array.length;
        if (n > 1) {
            int[] left = mergeSort(Arrays.copyOfRange(array, 0, n / 2));
            int[] right = mergeSort(Arrays.copyOfRange(array, n / 2, n));
            result = merge(left, right);
        }
        return result;
    }

    private static int[] merge(int[] left, int[] right) {
        int[] rsl = new int[left.length + right.length];
        int indexLeft = 0;
        int indexRight = 0;
        int i = 0;
        while (i < rsl.length) {
            if (indexLeft == left.length) {
              rsl[i] = right[indexRight++];
            } else if (indexRight == right.length) {
                rsl[i] = left[indexLeft++];
            } else if (left[indexLeft] <= right[indexRight]) {
                rsl[i] = left[indexLeft];
                indexLeft++;
            } else if (left[indexLeft] > right[indexRight]) {
                rsl[i] = right[indexRight];
                indexRight++;
            }
            i++;
        }
        return rsl;
    }

    public static void main(String[] args) {
        int[] array = {10, 4, 6, 4, 8, -13, 2, 3};
        System.out.println(Arrays.toString(mergeSort(array)));
    }
}
