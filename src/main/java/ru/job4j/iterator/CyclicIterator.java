package ru.job4j.iterator;

import java.util.Iterator;
import java.util.List;
import java.util.NoSuchElementException;

public class CyclicIterator<T> implements Iterator<T> {

    private List<T> data;
    private int index;


    public CyclicIterator(List<T> data) {
        this.data = data;
    }
    @Override
    public boolean hasNext() {
        return data.iterator().hasNext();
    }

    @Override
    public T next() {
        if (!hasNext()) {
            throw new NoSuchElementException();
        }
        while (index == data.size()) {
            index = 0;
        }
        return data.get(index++);
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3);
        CyclicIterator<Integer> iterator = new CyclicIterator<>(list);
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.next());
        System.out.println(iterator.hasNext());
    }
}
