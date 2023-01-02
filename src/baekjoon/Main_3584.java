package baekjoon;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_3584 {

    static int n;
    static int[] depthArr;
    static int[] parentArr;
    static List<Integer>[] nodes;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            init(br);
            dfs(findRootIdx(n) , 0);
            bw.write(findLca(br) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    private static void init(BufferedReader br) throws IOException {
        n = Integer.parseInt(br.readLine());
        depthArr = new int[n + 1];
        parentArr = new int[n + 1];
        nodes = new List[n + 1];

        for (int i = 0; i < nodes.length; i++) {
            nodes[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int parent = Integer.parseInt(st.nextToken());
            int child = Integer.parseInt(st.nextToken());

            parentArr[child] = parent;
            nodes[parent].add(child);
        }

        int startIdx = n;
        while (parentArr[startIdx] != 0) {
            startIdx = parentArr[startIdx];
        }

        dfs(startIdx , 0);

    }

    private static int findRootIdx(int n) {
        int startIdx = n;
        while (parentArr[startIdx] != 0) {
            startIdx = parentArr[startIdx];
        }

        return startIdx;
    }

    static void dfs(int cur, int depth) {
        depthArr[cur] = depth;
        for (int next : nodes[cur]) {
            dfs(next, depth + 1);
        }
    }

    private static int findLca(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        int a = Integer.parseInt(st.nextToken());
        int b = Integer.parseInt(st.nextToken());

        while (depthArr[a] > depthArr[b]) {
            a = parentArr[a];
        }

        while (depthArr[b] > depthArr[a]) {
            b = parentArr[b];
        }

        while (a != b) {
            a = parentArr[a];
            b = parentArr[b];
        }

        return a;
    }
}
