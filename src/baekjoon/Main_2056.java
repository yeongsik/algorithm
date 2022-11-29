package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_2056 {
    static int[] degrees;
    static List<Integer>[] adjacencyList;
    static List<Integer>[] degreeList;
    static int[] workTime;
    static int n;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        init();
        setData(br);
        solution();
        System.out.println(getMax());

    }

    private static void init() {
        degrees = new int[n + 1];
        workTime = new int[n + 1];
        adjacencyList = new List[n + 1];
        degreeList = new List[n + 1];
        dy = new int[n + 1];

        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
            degreeList[i] = new ArrayList<>();
        }
    }

    private static void setData(BufferedReader br) throws IOException {
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            workTime[i] = Integer.parseInt(st.nextToken());

            int j = Integer.parseInt(st.nextToken());
            for (int k = 0; k < j; k++) {
                int adjacency = Integer.parseInt(st.nextToken());
                adjacencyList[adjacency].add(i);
                degreeList[i].add(adjacency);
                degrees[i]++;
            }

            if (degrees[i] == 0) {
                dy[i] = workTime[i];
            }
        }
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i < n + 1; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }

        while (!queue.isEmpty()) {
            Integer curWork = queue.poll();
            for (int nextWork : adjacencyList[curWork]) {
                degrees[nextWork]--;
                if (degrees[nextWork] == 0) {
                    queue.add(nextWork);
                    int max = 0;
                    for (int degree : degreeList[nextWork]) {
                        max = Math.max(max, dy[degree]);
                    }
                    dy[nextWork] = max + workTime[nextWork];
                }
            }
        }
    }

    private static int getMax() {
        int max = 0;
        for (int x : dy) {
            max = Math.max(max, x);
        }
        return max;
    }

}
