package ru.job4j.newcoll.tree;


import ru.job4j.collection.Queue;
import ru.job4j.collection.SimpleQueue;
import java.util.*;

public class TreeUtils<T> {

    private void validateInput(Node<T> root) {
        if (root == null) {
            throw new IllegalArgumentException();
        }
    }

    /**
     * Метод выполняет обход дерева и считает количество узлов
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
     * Метод выполняет обход дерева и возвращает коллекцию ключей узлов дерева
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

    public static void main(String[] args) {
        Node<Integer> tree = new Node<>(1,
                new Node<>(2, new Node<>(4)),
                new Node<>(3)
        );
        TreeUtils<Integer> treeUtils = new TreeUtils<>();
       Iterable<Integer> list =  treeUtils.findAll(tree);
        System.out.println(list);
        int quantity = treeUtils.countNode(tree);
        System.out.println(quantity);
    }
}
