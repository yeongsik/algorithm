package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11437 {
    static int n, m;
    static List<Integer>[] conn;

    static Value[] values;
    static class Value {
        int parent;
        int depth;

        public Value(int depth, int parent) {
            this.depth = depth;
            this.parent = parent;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        n = Integer.parseInt(br.readLine());

        conn = new List[n + 1];
        values = new Value[n + 1];
        for (int i = 0; i < conn.length; i++) {
            conn[i] = new ArrayList<>();
        }


        for (int i = 0; i < n - 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            conn[a].add(b);
            conn[b].add(a);
        }

        // 트리 순환해서 조상이랑 depth 저장
        dfs(1,0,0);

        m = Integer.parseInt(br.readLine());

        for (int i = 0; i < m; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());

            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());


            while (values[a].depth > values[b].depth) {
                a = values[a].parent;
            }

            while (values[b].depth > values[a].depth) {
                b = values[b].parent;
            }

            while (a != b) {
                a = values[a].parent;
                b = values[b].parent;
            }

            bw.write(a + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }

    static void dfs(int cur , int depth , int parent) {

        values[cur] = new Value(depth, parent);

        for (int next : conn[cur]) {
            if (next != parent) {
                dfs(next, depth + 1, cur);
            }
        }
    }
}
