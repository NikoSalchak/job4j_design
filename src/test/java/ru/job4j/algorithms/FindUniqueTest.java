package ru.job4j.algorithms;

import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.*;

class FindUniqueTest {

    @Test
    public void findAppearsOneIsTwo() {
        Integer[] numbers = new Integer[]{2, 1, 1};
        int result = FindUnique.findSingleUnique(numbers);
        assertThat(result).isEqualTo(2);
    }

    @Test
    public void findAppearsOneIsSix() {
        Integer[] numbers = new Integer[]{6, 3, 5, 4, 5, 3, 4};
        int result = FindUnique.findSingleUnique(numbers);
        assertThat(result).isEqualTo(6);
    }
    @Test
    public void findAppearsOneIsThree() {
        Integer[] numbers = new Integer[]{1, 1, 2, 2, 3};
        int result = FindUnique.findSingleUnique(numbers);
        assertThat(result).isEqualTo(3);
    }
}