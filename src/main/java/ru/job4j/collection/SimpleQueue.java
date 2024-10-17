package ru.job4j.collection;

import java.util.NoSuchElementException;

public class SimpleQueue<T> implements Queue<T> {
    private final SimpleStack<T> input = new SimpleStack<>();
    private final SimpleStack<T> output = new SimpleStack<>();
    private int inputSize = 0;
    private int outputSize = 0;

    @Override
    public T poll() {
        if (inputSize == 0 && outputSize == 0) {
            throw new NoSuchElementException("Queue is empty");
        }
        if (outputSize == 0) {
            while (inputSize != 0) {
                output.push(input.pop());
                inputSize--;
                outputSize++;
            }
        }
        outputSize--;
        return output.pop();
    }

    @Override
    public T remove() {
        if (outputSize == 0) {
            while (inputSize != 0) {
                output.push(input.remove());
                inputSize--;
                outputSize++;
            }
        }
        outputSize--;
        return output.remove();
    }

    @Override
    public void push(T value) {
        input.push(value);
        inputSize++;
    }

    @Override
    public boolean isEmpty() {
        return inputSize == 0 && outputSize == 0;
    }
}
