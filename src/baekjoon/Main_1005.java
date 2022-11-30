package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1005 {

    static int T,N,K;
    static int[] structures;
    static int[] degrees;
    static int[] dy;
    static List<Integer>[] degreeList;
    static List<Integer>[] adjacencyList;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        T = Integer.parseInt(br.readLine());

        for (int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            init(st);
            setData(br);
            solution();
            int lastConstructor = Integer.parseInt(br.readLine());
            bw.write(dy[lastConstructor] + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < N + 1; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
                dy[i] = structures[i];
            }
        }

        while (!queue.isEmpty()) {
            int curStructure = queue.poll();
            if (adjacencyList[curStructure].size() > 0) {
                for (int next : adjacencyList[curStructure]) {
                    degrees[next]--;
                    if (degrees[next] == 0) {
                        queue.add(next);
                        int max = 0;
                        for (int degree : degreeList[next]) {
                            max = Math.max(max, dy[degree]);
                        }
                        dy[next] = max + structures[next];
                    }
                }
            }
        }
    }

    private static void setData(BufferedReader br) throws IOException {
        StringTokenizer st;
        st = new StringTokenizer(br.readLine());
        for (int i = 1; i < N + 1; i++) {
            structures[i] = Integer.parseInt(st.nextToken());
        }
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(to);
            degrees[to]++;
            degreeList[to].add(from);
        }

    }

    private static void init(StringTokenizer st) {
        N = Integer.parseInt(st.nextToken());
        K = Integer.parseInt(st.nextToken());

        structures = new int[N + 1];
        degrees = new int[N + 1];
        dy = new int[N + 1];
        degreeList = new List[N + 1];
        adjacencyList = new List[N + 1];

        for (int i = 0; i < N + 1; i++) {
            degreeList[i] = new ArrayList<>();
            adjacencyList[i] = new ArrayList<>();
        }
    }
}
