package ru.job4j.set;

import org.junit.jupiter.api.Test;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;

import static org.assertj.core.api.Assertions.*;

class SimpleArraySetTest {
    SimpleArraySet<Integer> set;

    @Test
    void whenAddNonNull() {
        set = new SimpleArraySet<>();
        assertThat(set.add(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.add(2)).isFalse();
    }

    @Test
    void whenAddSomeElementsNonNull() {
        set = new SimpleArraySet<>();
        assertThat(set.contains(1)).isFalse();
        assertThat(set.add(1)).isTrue();
        assertThat(set.contains(1)).isTrue();
        assertThat(set.add(1)).isFalse();
        assertThat(set.contains(2)).isFalse();
        assertThat(set.add(2)).isTrue();
        assertThat(set.contains(2)).isTrue();
        assertThat(set.add(2)).isFalse();
        assertThat(set.contains(3)).isFalse();
        assertThat(set.add(3)).isTrue();
        assertThat(set.contains(3)).isTrue();
        assertThat(set.add(3)).isFalse();
    }

    @Test
    void whenAddNull() {
        set = new SimpleArraySet<>();
        assertThat(set.add(null)).isTrue();
        assertThat(set.contains(null)).isTrue();
        assertThat(set.add(null)).isFalse();
    }

    @Test
    void whenAddAndUseIterator() {
        set = new SimpleArraySet<>();
        set.add(10);
        assertThat(set.contains(10)).isTrue();
        set.add(1);
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        while (iterator.hasNext()) {
            assertThat(iterator.next()).isEqualTo(10);
            assertThat(iterator.next()).isEqualTo(1);
            assertThat(iterator.next()).isEqualTo(2);
            assertThatThrownBy(iterator::next)
                    .isInstanceOf(NoSuchElementException.class);
        }
    }

    @Test
    void whenAddAfterGetIteratorThenMustBeException() {
        set = new SimpleArraySet<>();
        assertThat(set.add(0)).isTrue();
        assertThat(set.add(0)).isFalse();
        assertThat(set.contains(0)).isTrue();
        assertThat(set.add(1)).isTrue();
        set.add(2);
        Iterator<Integer> iterator = set.iterator();
        set.add(3);
        assertThatThrownBy(iterator::next)
                .isInstanceOf(ConcurrentModificationException.class);
    }
}