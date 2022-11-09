package inflearn.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Section7_12 {
    static int n, m, answer;
    static List<List<Integer>> graph;
    static boolean[] isVisited;

    public void DFS(int v) {
        if (v == n) {
            answer++;
            return;
        }
        for (int nextV : graph.get(v)) {
            if (!isVisited[nextV]) {
                isVisited[nextV] = true;
                DFS(nextV);
                isVisited[nextV] = false;
            }
        }
    }


    public static void main(String[] args) throws IOException {
        Section7_12 test = new Section7_12();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        graph = new ArrayList<>();
        for (int i = 0; i <= n; i++) {
            graph.add(new ArrayList<>());
        }
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            graph.get(a).add(b);
        }
        isVisited[1] = true;
        test.DFS(1);
        System.out.println(answer);
    }
}
