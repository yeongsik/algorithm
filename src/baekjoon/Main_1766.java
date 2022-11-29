package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1766 {

    static int N,M;
    static int[] problems;
    static int[] degrees;
    static List<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
        setData(br);
        solution(bw, initQueue());
        bw.flush();
        bw.close();
    }

    private static PriorityQueue<Integer> initQueue() {
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 1; i < N + 1; i++) {
            if (degrees[i] == 0) {
                pq.add(i);
            }
        }
        return pq;
    }

    private static void solution(BufferedWriter bw, PriorityQueue<Integer> pq) throws IOException {
        while (!pq.isEmpty()) {
            Integer curProblem = pq.poll();

            bw.write(curProblem + " ");

            if (adjacencyList[curProblem].size() > 0) {
                for (int next : adjacencyList[curProblem]) {
                    degrees[next]--;
                    if (degrees[next] == 0) {
                        pq.add(next);
                    }
                }
            }
        }
    }

    private static void setData(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(to);
            degrees[to]++;
        }
    }

    private static void init() {
        problems = new int[N + 1];
        degrees = new int[N + 1];
        adjacencyList = new List[N + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
        adjacencyList[i] = new ArrayList<>();
        }
    }
}
