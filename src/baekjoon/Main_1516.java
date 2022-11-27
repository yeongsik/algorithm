package baekjoon;

import java.io.*;
import java.util.*;

public class Main_1516 {

    static int[] degrees;
    static List<Integer>[] degreeList;
    static List<Integer>[] adjacencyList;
    static int[] structres;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        degrees = new int[n + 1];
        adjacencyList = new List[n + 1];
        degreeList = new List[n + 1];
        for (int i = 0; i < n + 1; i++) {
            adjacencyList[i] = new ArrayList<>();
            degreeList[i] = new ArrayList<>();
        }
        structres = new int[n + 1];
        dy = new int[n + 1];

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 1; i < n+1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            structres[i] = Integer.parseInt(st.nextToken());
            int check = Integer.parseInt(st.nextToken());
            while (check != -1) {
                adjacencyList[check].add(i);
                degreeList[i].add(check);
                check = Integer.parseInt(st.nextToken());
                degrees[i]++;
            }

            if (degrees[i] == 0) {
                queue.add(i);
                dy[i] = structres[i];
            }
        }

        while (!queue.isEmpty()) {
            Integer curStructure = queue.poll();

            if (adjacencyList[curStructure].size() > 0) {
                for (int element : adjacencyList[curStructure]) {
                    degrees[element]--;
                    if (degrees[element] == 0) {
                        queue.add(element);
                        int max = 0;
                        for (int x : degreeList[element]) {
                            max = Math.max(max, dy[x]);
                        }
                        dy[element] = max + structres[element];
                    }
                }
            }
        }

        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 1; i < n + 1; i++) {
            bw.write(dy[i] + "\n");
        }
        bw.flush();
    }
}
