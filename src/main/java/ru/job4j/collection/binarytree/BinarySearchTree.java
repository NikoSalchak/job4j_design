package ru.job4j.collection.binarytree;

import java.util.*;

public class BinarySearchTree<T extends Comparable<T>> {

    private Node root;

    public boolean put(T key) {
        boolean result;
        if (Objects.isNull(root)) {
            root = new Node(key);
            result = true;
        } else {
            result = put(root, key);
        }
        return result;
    }

    private boolean put(Node node, T key) {
        boolean rsl = false;
        if (node.compareTo(key) > 0) {
            if (Objects.isNull(node.getLeft())) {
                node.left = new Node(key);
                rsl = true;
            } else {
                rsl = put(node.left, key);
            }
        } else if (node.compareTo(key) < 0) {
            if (Objects.isNull(node.getRight())) {
                node.right = new Node(key);
                rsl = true;
            } else {
                rsl = put(node.right, key);
            }
        }
        return rsl;
    }

    public boolean contains(T key) {
        return this.find(root, key) != null;
    }

    private Node find(Node node, T key) {
        Node rsl = null;
        if (node.compareTo(key) > 0) {
            if (node.left != null && node.left.key.equals(key)) {
                rsl = node.left;
                return rsl;
            } else if (node.left != null) {
                rsl = find(node.left, key);
            }
        } else if (node.compareTo(key) < 0) {
            if (node.right != null && node.right.key.equals(key)) {
                rsl = node.right;
                return rsl;
            } else if (node.right != null) {
                rsl = find(node.right, key);
            }
        }
        return rsl;
    }

    public boolean remove(T key) {
        /* Метод будет реализован в следующих уроках */
        return false;
    }

    public List<T> inSymmetricalOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inSymmetricalOrder(node, result);
    }

    private List<T> inSymmetricalOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inSymmetricalOrder(localRoot.left, list);
            list.add(localRoot.key);
            inSymmetricalOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPreOrder() {
        List<T> result = new ArrayList<>();
        Node node = root;
        return inPreOrder(node, result);
    }

    private List<T> inPreOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            list.add(localRoot.key);
            inPreOrder(localRoot.left, list);
            inPreOrder(localRoot.right, list);
        }
        return list;
    }

    public List<T> inPostOrder() {
        List<T> rsl = new ArrayList<>();
        Node node = root;
        return inPostOrder(node, rsl);
    }

    private List<T> inPostOrder(Node localRoot, List<T> list) {
        if (localRoot != null) {
            inPostOrder(localRoot.left, list);
            inPostOrder(localRoot.right, list);
            list.add(localRoot.key);
        }
        return list;
    }

    public T minimum() {
        return Objects.nonNull(root) ? minimum(root).key : null;
    }

    private Node minimum(Node node) {
        Node rsl;
        if (Objects.nonNull(node.left)) {
            rsl = minimum(node.left);
        } else {
            rsl = node;
        }
        return rsl;
    }

    public T maximum() {
        return Objects.nonNull(root) ? maximum(root).key : null;
    }

    private Node maximum(Node node) {
        Node rsl;
        if (Objects.nonNull(node.right)) {
            rsl = maximum(node.right);
        } else {
            rsl = node;
        }
        return rsl;
    }

    @Override
    public String toString() {
        return PrintTree.getTreeDisplay(root);
    }

    private class Node implements VisualNode, Comparable<T> {
        private T key;
        private Node left;
        private Node right;

        public Node(T key) {
            this.key = key;
        }

        @Override
        public VisualNode getLeft() {
            return left;
        }

        @Override
        public VisualNode getRight() {
            return right;
        }

        @Override
        public String getText() {
            return key.toString();
        }

        @Override
        public int compareTo(T key) {
            return this.key.compareTo(key);
        }
    }
}
