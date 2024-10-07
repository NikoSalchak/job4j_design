package ru.job4j.algo;

import java.util.*;

public class QuickList {

    public static <T> void quickSort(List<T> sequence, Comparator<T> comparator) {
        quickSort(sequence, 0, sequence.size() - 1, comparator);
    }

    private static <T> void quickSort(List<T> sequence, int start, int end, Comparator<T> comparator) {
        if (start >= end) {
            return;
        }
        int h = breakPartition(sequence, start, end, comparator);
        quickSort(sequence, start, h - 1, comparator);
        quickSort(sequence, start + 1, end, comparator);
    }

    private static <T> int breakPartition(List<T> sequence, int start, int end, Comparator<T> comparator) {
        int leftIndex = start + 1;
        int rightIndex = end;
        T supportElement = sequence.get(start);
        while (true) {
            while (leftIndex < end && comparator.compare(sequence.get(leftIndex), supportElement) < 0) {
                leftIndex++;
            }
            while (comparator.compare(sequence.get(rightIndex), supportElement) > 0) {
                rightIndex--;
            }
            if (leftIndex >= rightIndex) {
                break;
            }
            swap(sequence, leftIndex++, rightIndex--);
        }
        swap(sequence, start, rightIndex);
        return rightIndex;
    }

    private static <T> void swap(List<T> sequence, int i, int j) {
        T temp = sequence.get(i);
        sequence.set(i, sequence.get(j));
        sequence.set(j, temp);
    }
}
