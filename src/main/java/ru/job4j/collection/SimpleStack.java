package ru.job4j.collection;

public class SimpleStack<T> {
    private ForwardLinked<T> linked = new ForwardLinked<>();

    public T pop() {
        return linked.deleteFirst();
    }

    public T remove() {
        return linked.removeFirst();
    }

    public void push(T value) {
        linked.addFirst(value);
    }
}
