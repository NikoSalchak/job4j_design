package ru.job4j.algo;

import java.util.Deque;
import java.util.LinkedList;

public class Brackets {

    public boolean isValid(String s) {
        boolean rsl = false;
        Deque<Character> deque = new LinkedList<>();
        for (int i = 0; i < s.length(); i++) {
            char currChar = s.charAt(i);
            if (currChar == ('(') || currChar == ('[') || currChar == ('{')) {
                deque.push(currChar);
            } else {
                if (deque.isEmpty()) {
                    return false;
                }
                char topChar = deque.pop();
                if ((currChar == ')' && topChar != '(') || (currChar == ']' && topChar != '[') || (currChar == '}' && topChar != '{')) {
                    return false;
                }
            }
        }
        return deque.isEmpty();
    }

    public static void main(String[] args) {
        System.out.println(new Brackets().isValid("()[]{}"));
        System.out.println(new Brackets().isValid("([]){"));
        System.out.println(new Brackets().isValid("({{{{}}}))"));

    }
}
