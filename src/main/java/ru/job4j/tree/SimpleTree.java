package ru.job4j.tree;

import java.util.LinkedList;
import java.util.Optional;
import java.util.Queue;
import java.util.function.Predicate;

public class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Node<E> newNode = new Node<>(child);
        Optional<Node<E>> optionalParent = findBy(parent);
        Optional<Node<E>> optionalChild = findBy(child);
        if (optionalParent.isPresent() && optionalChild.isEmpty()) {
            Node<E> node = optionalParent.get();
            node.children.add(newNode);
            rsl = true;
        }
        return rsl;
    }

    @Override
    public boolean isBinary() {
       Optional<Node<E>> optional = findByPredicate(el -> el.children.size() > 2);
       return optional.isEmpty();
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> result = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> element = data.poll();
            if (condition.test(element)) {
                result = Optional.of(element);
                break;
            }
            data.addAll(element.children);
        }
        return result;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(el -> el.value.equals(value));
    }
}
