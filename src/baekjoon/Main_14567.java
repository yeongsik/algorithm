package baekjoon;

import java.io.*;
import java.util.*;

public class Main_14567 {

    static int[] degrees;
    static List<Integer>[] adjacencyList;
    static int[] semesters;
    static int n;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        degrees = new int[n + 1];
        semesters = new int[n + 1];
        adjacencyList = new List[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(to);
            degrees[to]++;
        }

        solution();
        for (int i = 1; i < semesters.length; i++) {
            bw.write(semesters[i] + " ");
        }
        bw.flush();
        bw.close();
    }

    static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n + 1; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        int level = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int curV = queue.poll();
                semesters[curV] = level;

                if (adjacencyList[curV].size() > 0) {
                    for (int adjacentV : adjacencyList[curV]) {
                        degrees[adjacentV]--;
                        if (degrees[adjacentV] == 0) {
                            queue.add(adjacentV);
                        }
                    }
                }

            }
            level++;
        }
    }
}
