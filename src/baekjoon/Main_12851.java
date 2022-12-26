package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_12851 {

    static final boolean[] isVisitedMove = new boolean[100001];
    static final int[] moveX = {-1, 1,2};
    static int start,destination,time,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        start = Integer.parseInt(st.nextToken());
        destination = Integer.parseInt(st.nextToken());

        if (start == destination) {
            bw.write(time + "\n");
            bw.write(cnt+1 + "\n");
        } else {
            bfs();
            bw.write(time + "\n");
            bw.write(cnt + "\n");
        }
        bw.flush();
        bw.close();
    }

    private static void bfs() {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(start);
        isVisitedMove[start] = true;
        boolean isArrived = false;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                int cur = queue.poll();
                isVisitedMove[cur] = true;
                int next = 0;
                for (int j = 0; j < moveX.length; j++) {

                    if (moveX[j] == 2) {
                        next = cur * moveX[j];
                    } else {
                        next = cur + moveX[j];
                    }

                    if (next == destination) {
                        isArrived = true;
                        cnt++;
                    }

                    if (isValidArea(next) && !isVisitedMove[next]) {
                        queue.add(next);
                    }
                }
            }
            time++;
            if (isArrived) {
                return;
            }
        }
    }

    static boolean isValidArea(int x) {
        return x >= 0 && x < isVisitedMove.length;
    }
}
