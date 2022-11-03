package inflearn.section7;

import java.util.LinkedList;
import java.util.Queue;

public class Section7_7 {
    static class Node {
        int data;
        Node left;
        Node right;

        public Node(int data) {
            this.data = data;
            left = null;
            right = null;
        }
    }

    private Node root;

    public void BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;

        while (!queue.isEmpty()) {
            int len = queue.size();
            System.out.print(level + " : ");
            for (int i = 0; i < len; i++) {
                Node cur = queue.poll();
                System.out.print(cur.data);
                if (cur.left != null) {
                    queue.add(cur.left);
                }
                if (cur.right != null) {
                    queue.add(cur.right);
                }
            }
            level++;
            System.out.println();
        }

    }
    public static void main(String[] args) {

        Section7_7 tree = new Section7_7();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        tree.root.right.left = new Node(6);
        tree.root.right.right = new Node(7);

        tree.BFS(tree.root);
    }
}
