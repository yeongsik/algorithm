package inflearn.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section7_13 {

    static int n,m;
    static List<Integer>[] list;
    static boolean[] isVisited;
    static int[] dist;

    public void BFS(int v) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[v] = true;
        dist[v] = 0;
        queue.add(v);
        while (!queue.isEmpty()) {
            int currentV = queue.poll();
            for (int nextV : list[currentV]) {
                if (!isVisited[nextV]) {
                    isVisited[nextV] = true;
                    dist[nextV] = dist[currentV] + 1;
                    queue.add(nextV);
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Section7_13 test = new Section7_13();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        list = new List[n + 1];
        for (int i = 0; i < list.length; i++) {
            list[i] = new ArrayList<Integer>();
        }
        isVisited = new boolean[n + 1];
        dist = new int[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            list[a].add(b);
        }
        test.BFS(1);

        for (int i = 2; i < dist.length; i++) {
            System.out.println(i + " : " + dist[i]);
        }

    }
}
