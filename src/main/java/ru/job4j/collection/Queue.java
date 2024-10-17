package ru.job4j.collection;

public interface Queue<T> {

    T poll();

    T remove();

    void push(T value);

    boolean isEmpty();
}
