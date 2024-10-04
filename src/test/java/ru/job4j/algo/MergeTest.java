package ru.job4j.algo;

import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class MergeTest {

    @Test
    void whenSortedThenOk() {
        int[] array = {-13, 2, 3, 4, 4, 6, 8, 10};
        assertThat(Merge.mergeSort(array)).containsExactly(-13, 2, 3, 4, 4, 6, 8, 10);
    }
    @Test
    void whenSortedThenOkToo() {
        int[] array = {1, 2, 3, 4, 5};
        assertThat(Merge.mergeSort(array)).containsSequence(1, 2, 3, 4, 5);
    }

    @Test
    void whenSorThenSEqual() {
        int[] array = {5, 5, 5, 5, 5};
        assertThat(Merge.mergeSort(array)).isEqualTo(new int[]{5, 5, 5, 5, 5});
    }

    @Test
    void whenSortThenFalse() {
        int[] array = {10, 9, 8, 7, 6};
        assertThat(Merge.mergeSort(array)).isNotEqualTo(new int[]{10, 9, 8, 7, 6});
    }


}