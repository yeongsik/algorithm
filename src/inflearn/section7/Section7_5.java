package inflearn.section7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.util.Objects;


public class Section7_5 {

    static class Node {
        int data;
        Node left, right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }
    Node root;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public void DFS(Node root) {

    }
    public void preOrder(Node root) throws IOException {
        if (Objects.isNull(root)) {
            return;
        }
        bw.write(root.data + " ");
        preOrder(root.left);
        preOrder(root.right);
    }

    public void inOrder(Node root) throws IOException {
        if (Objects.isNull(root)) {
            return;
        }
        inOrder(root.left);
        bw.write(root.data + " ");
        inOrder(root.right);
    }

    public void postOrder(Node root) throws IOException {
        if (Objects.isNull(root)) {
            return;
        }
        postOrder(root.left);
        postOrder(root.right);
        bw.write(root.data + " ");
    }
    public static void main(String[] args) throws IOException {
        Section7_5 tree = new Section7_5();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);


        tree.preOrder(tree.root);
        bw.write("\n");
        bw.flush();
        tree.inOrder(tree.root);
        bw.write("\n");
        bw.flush();
        tree.postOrder(tree.root);
        bw.write("\n");
        bw.flush();
    }
}
