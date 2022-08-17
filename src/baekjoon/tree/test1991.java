package baekjoon.tree;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class test1991 {

    static class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }

    static List<Node>[] list;
    static StringBuilder sb = new StringBuilder();

    public static void main(String[] args) throws NumberFormatException, IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine());
        list = new ArrayList[n + 1];
        for (int i = 0; i < n; i++) {
            list[i] = new ArrayList<>();
        }
        for (int i = 0; i < n; i++) {
            String[] line = br.readLine().split(" ");

            int data = line[0].charAt(0) - 'A';
            int left = line[1].charAt(0) - 'A';
            int right = line[2].charAt(0) - 'A';
            list[data].add(new Node(left, right));

        }

        preOrder(0);
        sb.append("\n");
        inOrder(0);
        sb.append("\n");
        postOrder(0);
        sb.append("\n");
        System.out.println(sb.toString());
    }

    private static void preOrder(int x){
        for (Node node : list[x]){
            int l = node.left;
            int r = node.right;

            sb.append((char) (x + 'A'));
            if(l != -19) {
                preOrder(l);
            }
            if (r != -19) {
                preOrder(r);
            }
        }
    }

    private static void inOrder(int x) {
        for (Node node : list[x]) {
            int l = node.left;
            int r = node.right;

            if (l != -19) {
                inOrder(l);
            }
            sb.append((char) (x + 'A'));
            if (r != -19) {
                inOrder(r);
            }
        }
    }

    private static void postOrder(int x) {
        for (Node node : list[x]) {
            int l = node.left;
            int r = node.right;

            if (l != -19) {
                postOrder(l);
            }
            if (r != -19) {
                postOrder(r);
            }
            sb.append((char) (x + 'A'));
        }
    }
}
