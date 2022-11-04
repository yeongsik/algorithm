package inflearn.section7;

import java.util.LinkedList;
import java.util.Queue;

public class Section7_10 {
    static class Node{
        private int data;
        private Node left;
        private Node right;

        public Node(int data) {
            this.data = data;
            this.left = null;
            this.right = null;
        }
    }

    public int BFS(Node root) {
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Node curNode = queue.poll();

                if (curNode.left == null && curNode.right == null) {
                    return level;
                }
                if (curNode.left != null) {
                    queue.add(curNode.left);
                }
                if (curNode.right != null) {
                    queue.add(curNode.right);
                }
            }
            level++;
        }
        return 0;
    }
    private Node root;
    public static void main(String[] args) {
        Section7_10 tree = new Section7_10();
        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.BFS(tree.root));
    }
}
