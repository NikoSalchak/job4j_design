package ru.job4j.iterator;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.*;

class ListUtilsTest {
    private List<Integer> input;
    private List<String> list;

    @BeforeEach
    void setUp() {
        input = new ArrayList<>(Arrays.asList(1, 3));
    }

    @BeforeEach
    void secondSetUp() {
        list = new ArrayList<>(Arrays.asList("I am", "still", "continue", "learning"));
    }

    @Test
    void whenAddBefore() {
        ListUtils.addBefore(input, 1, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddBeforeWithInvalidIndex() {
        assertThatThrownBy(() -> ListUtils.addBefore(input, 3, 2))
                .isInstanceOf(IndexOutOfBoundsException.class);
    }

    @Test
    void whenAddAfter() {
        ListUtils.addAfter(input, 0, 2);
        assertThat(input).hasSize(3).containsSequence(1, 2, 3);
    }

    @Test
    void whenAddAndRemoveIf() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        assertThat(input).containsSequence(1, 2, 3, 4, 5);
        Predicate<Integer> predicate = el -> el % 2 == 0;
        ListUtils.removeIf(input, predicate);
        assertThat(input).hasSize(3).containsSequence(1, 3, 5);
    }

    @Test
    void whenStringListReplaceIf() {
        Predicate<String> stringPredicate = el -> el.contains("I am");
        String value = "We are";
        ListUtils.replaceIf(list, stringPredicate, value);
        assertThat(list).hasSize(4).containsSequence("We are", "still", "continue", "learning");
    }

    @Test
    void whenHaveTwoListRemoveAll() {
        ListUtils.addBefore(input, 1, 2);
        ListUtils.addAfter(input, 2, 4);
        ListUtils.addAfter(input, 3, 5);
        assertThat(input).containsSequence(1, 2, 3, 4, 5);
        List<Integer> deleteList = new ArrayList<>(Arrays.asList(1, 2));
        ListUtils.removeAll(input, deleteList);
        assertThat(input).containsSequence(3, 4, 5);
    }
}