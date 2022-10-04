package baekjoon.dfs;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class N1967 {
    static int N;
    static int max;
    static int maxIdx;
    static class Node {
        int num;
        int len;
        public Node(int num , int len) {
            this.num = num;
            this.len = len;
        }

        @Override
        public String toString() {
            return "Node{" +
                    "num=" + num +
                    ", len=" + len +
                    '}';
        }
    }
    static List<Node>[] nodeList;
    static boolean[] visit;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter out = new BufferedWriter(new OutputStreamWriter(System.out));

        N = Integer.parseInt(in.readLine());
        nodeList = new List[N + 1];

        for (int i = 0; i <= N; i++) {
            nodeList[i] = new ArrayList<>();
        }

        for (int i = 0; i < N - 1; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            int len = Integer.parseInt(st.nextToken());

            nodeList[from].add(new Node(to, len));
            nodeList[to].add(new Node(from, len));
        }

        visit = new boolean[N + 1];
        visit[1] = true;
        dfs(1, 0);
        System.out.println("maxIdx = " + maxIdx);
        System.out.println("max = " + max);

        visit = new boolean[N + 1];
        visit[maxIdx] = true;
        dfs(maxIdx,0);

        System.out.println("maxIdx = " + maxIdx);
        System.out.println("max = " + max);

        /*
        out.flush 했을 때 - 값이 나온다 why??

         */
    }

    /*
    DFS 로직


     */
    private static void dfs(int num, int dim) {

        if (max < dim) {
            max = dim;
            maxIdx = num;
        }
        for (Node node : nodeList[num]) {
            if (!visit[node.num]) {
                visit[node.num] = true;
                dfs(node.num, dim + node.len);
            }
        }
    }
}
