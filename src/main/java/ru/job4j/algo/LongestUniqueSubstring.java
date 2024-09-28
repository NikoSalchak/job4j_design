package ru.job4j.algo;

import java.util.*;

public class LongestUniqueSubstring {

    public static String longestUniqueSubstring(String str) {
        Map<Character, Integer> visited = new HashMap<>();
        String output = "";
        int start = 0;
        for (int end = 0; end < str.length(); end++) {
            char currChar = str.charAt(end);
            if (visited.containsKey(currChar)) {
                start = Math.max(visited.get(currChar) + 1, start);
            }
            if (output.length() < end - start + 1) {
                output = str.substring(start, end + 1);
            }
            visited.put(currChar, end);
        }
        return output;
    }

    public static void main(String[] args) {
        String str = "abcbcde";
        String rsl = longestUniqueSubstring(str);
        System.out.println(rsl);
    }
}
