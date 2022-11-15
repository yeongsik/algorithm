package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1926 {

    static boolean[][] isVisited;
    static int[][] paper;
    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
    static final int paint = 1;
    static int n, m, cnt, max;
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());
        paper = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && paper[i][j] == paint) {
                    BFS(new Point(j, i));
                    cnt++;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        bw.write(cnt + "\n");
        bw.write(max + "\n");
        bw.flush();
        bw.close();
    }

    static void BFS(Point point) {
        int level = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point curPoint = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Point nextPoint = new Point(curPoint.x + DIRECTION_X[j], curPoint.y + DIRECTION_Y[j]);
                    if (isValidArea(nextPoint) && !isVisited[nextPoint.y][nextPoint.x] && paper[nextPoint.y][nextPoint.x] == paint) {
                        queue.add(nextPoint);
                        isVisited[nextPoint.y][nextPoint.x] = true;
                        level++;
                    }
                }
            }
        }
        max = Math.max(max, level);
    }

    static boolean isValidArea(Point point) {
        return point.x >= 0 && point.x < m && point.y >= 0 && point.y < n;
    }
}
