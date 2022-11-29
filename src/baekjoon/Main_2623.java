package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2623 {

    static int N,M;
    static int[] degrees;
    static int[] team;
    static List<Integer>[] adjacencyList;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        init();
        setData(br);
        solution(bw);
        printResult(bw);
    }

    private static void printResult(BufferedWriter bw) throws IOException {
        boolean isPossible = true;
        for (int x : degrees) {
            if (x > 0) {
                isPossible = false;
                break;
            }
        }
        if (isPossible) {
            bw.flush();
            bw.close();
        } else {
            System.out.println(0);
        }
    }

    private static void solution(BufferedWriter bw) throws IOException {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N+1; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                bw.write(i + "\n");
            }
        }
        while (!queue.isEmpty()) {
            Integer curTeam = queue.poll();

            for (int otherTeam : adjacencyList[curTeam]) {
                degrees[otherTeam]--;
                if (degrees[otherTeam] == 0) {
                    queue.add(otherTeam);
                    bw.write(otherTeam + "\n");
                }
            }
        }
    }

    private static void setData(BufferedReader br) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int cntTeamInCharge = Integer.parseInt(st.nextToken());
            int from = Integer.parseInt(st.nextToken());
            for (int j = 0; j < cntTeamInCharge-1; j++) {
                int to = Integer.parseInt(st.nextToken());
                adjacencyList[from].add(to);
                degrees[to]++;
                from = to;
            }
        }
    }

    private static void init() {
        degrees = new int[N + 1];
        team = new int[N + 1];
        adjacencyList = new List[N + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }
    }
}
