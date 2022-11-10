package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_14940 {

    static int[][] fields;
    static boolean[][] isVisited;
    static int[][] dist;
    static int n,m;
    static Point targetPoint;
    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
    static final int POSSIBLE_LAND = 1;
    static final int TARGET_POINT = 2;
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
        fields = new int[n][m];
        isVisited = new boolean[n][m];
        dist = new int[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                fields[i][j] = Integer.parseInt(st.nextToken());
                if (fields[i][j] == TARGET_POINT) {
                    targetPoint = new Point(j, i);
                }
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                dist[i][j] = -1;
            }
        }
        BFS();

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (fields[i][j] == 0) {
                    dist[i][j] = 0;
                }
            }
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                bw.write(dist[i][j] + " ");
            }
            bw.write("\n");
        }
        bw.flush();
        bw.close();

    }

    static void BFS() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(targetPoint);
        isVisited[targetPoint.y][targetPoint.x] = true;
        dist[targetPoint.y][targetPoint.x] = 0;

        while (!queue.isEmpty()) {
            Point currentP = queue.poll();
            for (int j = 0; j < 4; j++) {
                Point nextP = new Point(DIRECTION_X[j] + currentP.x, DIRECTION_Y[j] + currentP.y);
                if (isValidArea(nextP) && !isVisited[nextP.y][nextP.x] && isPossibleLand(nextP)) {
                    queue.add(nextP);
                    isVisited[nextP.y][nextP.x] = true;
                    dist[nextP.y][nextP.x] = dist[currentP.y][currentP.x] + 1;
                }
            }
        }
    }
    static boolean isValidArea(Point point) {
        return point.x >= 0 && point.x < m && point.y >= 0 && point.y < n;
    }

    static boolean isPossibleLand(Point point) {
        return fields[point.y][point.x] == POSSIBLE_LAND;
    }
}
