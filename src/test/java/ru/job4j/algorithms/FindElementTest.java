package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;

import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.*;

class FindElementTest {

    @Test
    public void findMissingThreeAndFive() {
        List<Integer> sortedList = Arrays.asList(1, 1, 2, 4, 6, 6, 7, 8, 9, 10, 10);
        List<Integer> result = FindElement.findMissingElements(sortedList);
        assertThat(result).isEqualTo(List.of(3, 5));
    }

    @Test
    public void findMissingTwo() {
        List<Integer> sortedList = Arrays.asList(1, 3, 4);
        List<Integer> result = FindElement.findMissingElements(sortedList);
        assertThat(result).isEqualTo(List.of(2));
    }

    @Test
    public void findDuplicateOneSixTen() {
        List<Integer> sortedList = Arrays.asList(1, 1, 2, 4, 6, 6, 7, 8, 9, 10, 10);
        List<Integer> result = FindElement.findDuplicateElements(sortedList);
        assertThat(result).isEqualTo(List.of(1, 6, 10));
    }

    @Test
    public void findDuplicateFiveSeven() {
        List<Integer> sortedList = Arrays.asList(1, 2, 4, 5, 5, 7, 7);
        List<Integer> result = FindElement.findDuplicateElements(sortedList);
        assertThat(result).isEqualTo(List.of(5, 7));
    }
}