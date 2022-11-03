package inflearn.section7;

public class Section7_9 {
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
    private Node root;
    public int DFS(int level, Node node) {
        if (node.left == null && node.right == null) {
            return level;
        }
        return Math.min(DFS(level + 1, node.left), DFS(level + 1, node.right));
    }
    public static void main(String[] args) {
        Section7_9 tree = new Section7_9();

        tree.root = new Node(1);
        tree.root.left = new Node(2);
        tree.root.right = new Node(3);
        tree.root.left.left = new Node(4);
        tree.root.left.right = new Node(5);
        System.out.println(tree.DFS(0,tree.root));
    }
}
