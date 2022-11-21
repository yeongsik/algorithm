package baekjoon;

import java.io.*;
import java.util.*;

public class Main_2252 {

    static List<Integer>[] adjacencyList;
    static int[] degrees;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        adjacencyList = new List[n + 1];
        degrees = new int[n + 1];
        for (int i = 0; i < adjacencyList.length; i++) {
            adjacencyList[i] = new ArrayList<>();
        }

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            adjacencyList[from].add(to);
            degrees[to]++;
        }

        for (int x : solution()) {
            bw.write(x + " ");
        }
        bw.flush();
        bw.close();
    }

    static List<Integer> solution() {
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < degrees.length; i++) {
            if (degrees[i] == 0) {
                queue.add(i);
            }
        }
        List<Integer> list = new ArrayList<>();
        while (!queue.isEmpty()) {
            Integer curNode = queue.poll();
            list.add(curNode);
            if (adjacencyList[curNode].size() > 0) {
                for (int nextNode : adjacencyList[curNode]) {
                    degrees[nextNode]--;
                    if (degrees[nextNode] == 0) {
                        queue.add(nextNode);
                    }
                }
            }
        }
        return list;
    }
}
