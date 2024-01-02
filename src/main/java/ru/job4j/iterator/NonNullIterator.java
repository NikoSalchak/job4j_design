package ru.job4j.iterator;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class NonNullIterator implements Iterator<Integer> {
    private Integer[] data;
    private int index;

    public NonNullIterator(Integer[] data) {
        this.data = data;
        this.index = -1;
        fixNext();
    }

    @Override
    public boolean hasNext() {
        return index < data.length;
    }

    @Override
    public Integer next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        int rsl = data[index];
        fixNext();
        return rsl;
    }

    private void fixNext() {
        index++;
        while (index < data.length && data[index] == null) {
            index++;
        }
    }

    public static void main(String[] args) {
        NonNullIterator iterator = new NonNullIterator(
                new Integer[]{4, 2, null, null}
        );
        System.out.println(iterator.next());
        System.out.println(iterator.next());
    }
}
