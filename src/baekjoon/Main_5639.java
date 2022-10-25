package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public class Main_5639 {

    static Node<Integer> root;
    static StringBuilder sb = new StringBuilder();
    static class Node<T>{
        private T key;
        private Node<T> left;
        private Node<T> right;

        Node(T key) {
            this.key = key;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        while (true) {
            String s = in.readLine();
            if (s == null || s.equals("")) {
                break;
            }
            add(Integer.parseInt(s), root);
        }
        postOrder(root);
        System.out.println(sb);
    }

    static void add(int data, Node idx) {
        if (Objects.isNull(root)) {
            root = new Node<>(data);
            return;
        }
        if (data > (int)idx.key) {
            if (Objects.isNull(idx.right)) {
                idx.right = new Node<>(data);
                return;
            }
            add(data, idx.right);
            return;
        }
        if (data < (int)idx.key) {
            if (Objects.isNull(idx.left)) {
                idx.left = new Node<>(data);
                return;
            }
            add(data, idx.left);
        }
    }

    static void postOrder(Node node) {
        if (!Objects.isNull(node.left)) {
            postOrder(node.left);
        }
        if (!Objects.isNull(node.right)) {
            postOrder(node.right);
        }
        sb.append(node.key + "\n");
    }
}
