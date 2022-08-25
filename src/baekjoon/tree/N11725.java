package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class N11725 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        Tree<Character> tree = new Tree();
        for (int i = 0; i < size-1; i++) {
            char[] nodeArray = br.readLine().trim().replace(" ","").toCharArray();
            tree.add(nodeArray[0]);
            tree.add(nodeArray[1]);
        }
        tree.preOrder();
    }

}
class Tree<V> {
    private static class Node<V> {
        private V data;
        private Node<V> left;
        private Node<V> right;

        Node(V data) {
            this.data = data;
        }

        public V getData() {
            return data;
        }

        public Node<V> getLeft() {
            return left;
        }

        public void setLeft(Node<V> left) {
            this.left = left;
        }

        public Node<V> getRight() {
            return right;
        }

        public void setRight(Node<V> right) {
            this.right = right;
        }
    }
    private Node<V> root;

    public void add(V data) {
        if (Objects.isNull(root)) {
            root = new Node<>(data);
            System.out.println("root :" + root.getData());
            return;
        }
        add(root, data);

    }

    private void add(Node<V> pointer, V data) {
        if (pointer.getData().equals(data)) {
            System.out.println("pointer.getData equal data = " + data);
            return;
        }
        if (Objects.isNull(pointer.getLeft())) {
            pointer.setLeft(new Node<>(data));
            System.out.println("pointer.getLeft() = " + pointer.getLeft().getData());
            return;
        }
        if (Objects.isNull(pointer.getRight())) {
            pointer.setRight(new Node<>(data));
            System.out.println("pointer.getRight() = " + pointer.getRight().getData());
            return;
        }
        add(pointer.getLeft(), data);
        add(pointer.getRight(), data);
    }

    public void preOrder() {
        preOrder(root);
    }

    private void preOrder(Node<V> node) {
        if (Objects.isNull(node)) {
            return;
        }
        System.out.print(node.getData());
        preOrder(node.getLeft());
        preOrder(node.getRight());
    }

}
