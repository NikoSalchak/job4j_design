package ru.job4j.algorithms;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class FindUnique {
    public static int findSingleUnique(Integer[] numbers) {
        Map<Integer, Integer> map = new HashMap<>();
        Arrays.sort(numbers);
        int result = -1;
        for (int i = 0; i < numbers.length; i++) {
            int freq = map.getOrDefault(numbers[i], 0);
            map.put(numbers[i], freq + 1);
        }
        for (int i = 0; i < numbers.length; i++) {
            if (map.get(numbers[i]) == 1) {
                result = numbers[i];
            }
        }
        return result;
    }
}
