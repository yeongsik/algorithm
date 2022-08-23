package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class N1991 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int size = Integer.parseInt(br.readLine());
        int i = 0;
        Tree<String> tree = new Tree<>();

        while (i < size) {
            String[] inputValues = br.readLine().split(" ");
            tree.add(inputValues[0], inputValues[1], inputValues[2]);
            i++;
        }

        tree.preOrder(tree.root);
        System.out.println();
        tree.inOrder(tree.root);
        System.out.println();
        tree.postOrder(tree.root);

    }
    private static class Tree<V> {
        static class Node<V> {
            private V data;
            private Node<V> left;
            private Node<V> right;

            Node(V data, V left, V right) {
                this.data = data;
                this.left = new Node(left);
                this.right = new Node(right);
            }

            Node(V data) {
                this.data = data;
            }

            public void printValue() {
                System.out.println("data = " + data);
                System.out.println("left = " + left.data);
                System.out.println("right = " + right.data);
            }
        }

        private Node<V> root;
        private int size;
        private Node<V> pointer;

        // TODO: 2022-08-23 NPE 발생 해결하기 
        void add(V data , V left, V right) {
            if (Objects.isNull(root)) {
                root = new Node(data, left, right);
                pointer = root;
                return;
            }
            if (pointer.data.equals(data)) {
                if (left.equals(".")) {
                    pointer.left = null;
                }
                if (right.equals(".")) {
                    pointer.right = null;
                } else {
                    pointer.left = new Node<V>(left, null, null);
                    pointer.right = new Node<V>(right, null, null);
                }
            } else {
                if (pointer.left != null) {
                    pointer = pointer.left;
                    add(data, left, right);
                }
                if (pointer.right != null) {
                    pointer = pointer.right;
                    add(data, left, right);
                }
            }

        }


        void preOrder(Node<V> node){
            if (Objects.isNull(node)) {
                return;
            }
            System.out.print(node.data);
            preOrder(node.left);
            preOrder(node.right);
        }

        void inOrder(Node<V> node) {
            if (Objects.isNull(node)) {
                return;
            }
            inOrder(node.left);
            System.out.print(node.data);
            inOrder(node.right);
        }

        void postOrder(Node<V> node) {
            if (Objects.isNull(node)) {
                return;
            }
            postOrder(node.left);
            postOrder(node.right);
            System.out.print(node.data);
        }
    }

}
