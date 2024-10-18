package ru.job4j.newcoll.tree;


import ru.job4j.collection.Queue;
import ru.job4j.collection.SimpleQueue;
import ru.job4j.collection.SimpleStack;

import java.util.*;

public class TreeUtils<T> {

    private void validateInput(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод выполняет обход дерева (обход в ширину) и считает количество узлов
     * @param root корневой узел дерева
     * @return количество узлов
     * @throws IllegalArgumentException если root является null
     */
    public int countNode(Node<T> root) {
        this.validateInput(root);
        Queue<Node<T>> queue = new SimpleQueue<>();
        queue.push(root);
        int quantity = 0;
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            for (Node<T> n : node.getChildren()) {
                queue.push(n);
            }
            quantity++;
        }
        return quantity;
    }

    /**
     * Метод выполняет обход дерева (обход в ширину) и возвращает коллекцию ключей узлов дерева
     * @param root корневой узел
     * @return коллекция с ключами, реализующая интерфейс Iterable<E>
     * @throws IllegalArgumentException если root является null
     */
    public Iterable<T> findAll(Node<T> root) {
        this.validateInput(root);
        Queue<Node<T>> queue = new SimpleQueue<>();
        List<T> rsl = new ArrayList<>();
        queue.push(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.remove();
            rsl.add(node.getValue());
            for (Node<T> n : node.getChildren()) {
                queue.push(n);
            }
        }
        return rsl;
    }

    /**
     * Метод обходит дерево (обход в глубину) root и добавляет к узлу с ключом parent
     * новый узел с ключом новый узел с ключом child, при этом на момент добавления узел с ключом parent
     * должен существовать в дереве, а узла с ключом child в дереве не должно
     * @param root корень дерева
     * @param parent ключ узла-родителя
     * @param child ключ узла-потомка
     * @return true если добавление произошло успешно и false в обратном случае
     * @throws IllegalArgumentException если root является null
     */
    public boolean add(Node<T> root, T parent, T child) {
        this.validateInput(root);
        boolean rsl = false;
        Optional<Node<T>> parentRoot = this.findByKey(root, parent);
        Optional<Node<T>> childRoot = this.findByKey(root, child);
        if (parentRoot.isPresent() && childRoot.isEmpty()) {
            parentRoot.get().getChildren().add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @throws IllegalArgumentException если root является null
     */
    public Optional<Node<T>> findByKey(Node<T> root, T key) {
        this.validateInput(root);
        Optional<Node<T>> optional = Optional.empty();
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        while (!stack.isEmpty()) {
            Node<T> node = stack.remove();
            if (node.getValue().equals(key)) {
                optional = Optional.of(node);
                break;
            }
            for (Node<T> n : node.getChildren()) {
                stack.push(n);
            }
        }
        return optional;
    }

    /**
     * Метод обходит дерево root и возвращает первый найденный узел с ключом key,
     * при этом из дерева root удаляется все поддерево найденного узла
     * @param root корень дерева
     * @param key ключ поиска
     * @return узел с ключом key, завернутый в объект типа Optional
     * @thrown IllegalArgumentException если root является null
     */
    public Optional<Node<T>> divideByKey(Node<T> root, T key) {
        this.validateInput(root);
        Optional<Node<T>> optional = Optional.empty();
        Optional<Node<T>> node = this.findByKey(root, key);
        if (node.isPresent()) {
            int i = 0;
            Node<T>[] arr = new Node[node.get().getChildren().size()];
            while (i < node.get().getChildren().size()) {
                arr[i] = node.get().getChildren().get(i);
                optional = Optional.of(new Node<T>(node.get().getValue(), arr));
                i++;
            }
        }
        this.deleteNode(root, key);
        return optional;
    }

    private void deleteNode(Node<T> root, T key) {
        SimpleStack<Node<T>> stack = new SimpleStack<>();
        stack.push(root);
        int i = 0;
        while (!stack.isEmpty()) {
            Node<T> deleteNode = stack.remove();
            while (i < deleteNode.getChildren().size()) {
                if (deleteNode.getChildren().get(i).getValue().equals(key)) {
                    deleteNode.getChildren().remove(i);
                    break;
                }
                i++;
            }
            for (Node<T> n : deleteNode.getChildren()) {
                stack.push(n);
            }
        }
    }
}
