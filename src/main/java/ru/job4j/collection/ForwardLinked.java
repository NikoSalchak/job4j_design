package ru.job4j.collection;

import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Objects;

public class ForwardLinked<T> implements Iterable<T> {
    private int size = 0;
    private int modCount;
    private Node<T> head;

    public void add(T value) {
        final Node<T> newNode = new Node<>(value, null);
        Node<T> current = head;
        if (current == null) {
            head = newNode;
        } else {
            while (current.next != null) {
                current = current.next;
            }
            current.next = newNode;
        }
        size++;
        modCount++;
    }

    public T get(int index) {
        Objects.checkIndex(index, size);
        Node<T> current = head;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        return current.item;
    }

    public T deleteFirst() {
        if (head == null) {
            throw new NoSuchElementException();
        }
        Node<T> temp = head;
        T item = temp.item;
        head.item = null;
        head = head.next;
        temp.next = null;
        size--;
        modCount++;
        return item;
    }

    @Override
    public Iterator<T> iterator() {
        return new Iterator<T>() {
            Node<T> current = head;
            final int expectedMountCount = modCount;

            @Override
            public boolean hasNext() {
                if (modCount != expectedMountCount) {
                    throw new ConcurrentModificationException();
                }
                return current != null;
            }

            @Override
            public T next() {
                if (!hasNext()) {
                    throw new ConcurrentModificationException();
                }
                T item = current.item;
                current = current.next;
                return item;
            }
        };
    }

    private static class Node<T> {
        private T item;
        private Node<T> next;

        Node(T element, Node<T> next) {
            this.item = element;
            this.next = next;
        }
    }
}
