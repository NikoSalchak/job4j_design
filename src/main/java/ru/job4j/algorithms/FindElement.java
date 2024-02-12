package ru.job4j.algorithms;
import java.util.*;

public class FindElement {

    public static List<Integer> findMissingElements(List<Integer> list) {
        int[] array = new int[list.get(list.size() - 1) + 1];
        List<Integer> result = new ArrayList<>();
        for (Integer i : list) {
            array[i] = 1;
        }
        for (int i = 1; i < array.length; i++) {
            if (array[i] == 0) {
                result.add(i);
            }
        }
        return result;
    }

    public static List<Integer> findDuplicateElements(List<Integer> list) {
        Set<Integer> duplicates = new HashSet<>();
        List<Integer> result = new ArrayList<>();
        for (Integer integer : list) {
            if (!duplicates.add(integer)) {
                result.add(integer);
            }
        }
        return result;
    }
}
