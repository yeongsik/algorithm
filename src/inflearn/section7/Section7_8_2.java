package inflearn.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Section7_8_2 {
    static int[] dist = {1, -1, 5};
    static int[] ch;
    static Queue<Integer> queue = new LinkedList<>();
    static int BFS(int start, int end) {
        ch = new int[10001];
        ch[start] = 1;
        queue.offer(start);
        int L = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int x = queue.poll();
                if (x == end) {
                    return L;
                }
                for (int j = 0; j < 3; j++) {
                    int nx = x + dist[j];
                    if (nx >= 1 && nx <= 10000 && ch[nx] == 0) {
                        ch[nx] = 1;
                        queue.offer(nx);
                    }
                }
            }
            L++;
        }
        return 0;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int start = Integer.parseInt(st.nextToken());
        int end = Integer.parseInt(st.nextToken());

        System.out.println(BFS(start,end));
    }
}
