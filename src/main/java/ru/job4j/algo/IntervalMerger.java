package ru.job4j.algo;

import java.util.*;

public class IntervalMerger {

    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, Comparator.comparingInt(a -> a[0]));
        List<int[]> merged = new ArrayList<>();
        int[] prev = intervals[0];
        for (int i = 1; i < intervals.length; i++) {
            int[] nextArr = intervals[i];
            if (prev[1] >= nextArr[0]) {
                prev[1] = Math.max(prev[1], nextArr[1]);
            } else {
                merged.add(prev);
                prev = nextArr;
            }
        }
        merged.add(prev);
        return merged.toArray(new int[merged.size()][]);
    }
}
