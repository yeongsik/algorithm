package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7576 {
    static int m,n,days;
    static int[][] fields;
    static boolean[][] isVisited;
    static Queue<Point> queue = new LinkedList<>();
    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
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
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());

        fields = new int[n][m];
        isVisited = new boolean[n][m];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                fields[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (fields[i][j] == 1) {
                    queue.add(new Point(j,i));
                    isVisited[i][j] = true;
                }
            }
        }
        BFS();
        boolean isFruit = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (fields[i][j] == 0) {
                    if (!isVisited[i][j]) {
                        isFruit = false;
                    }
                }
            }
        }
        if (!isFruit) {
            System.out.println(-1);
        } else {
            System.out.println(days-1);
        }
    }

    static void BFS() {
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point currentP = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Point nextP = new Point(DIRECTION_X[j] + currentP.x, DIRECTION_Y[j] + currentP.y);
                    if (isValidArea(nextP) && !isVisited[nextP.y][nextP.x] && fields[nextP.y][nextP.x] == 0) {
                        queue.add(nextP);
                        isVisited[nextP.y][nextP.x] = true;
                    }
                }
            }
            days++;
        }
    }

    static boolean isValidArea(Point point) {
        return point.x >= 0 && point.x < m && point.y >= 0 && point.y < n;
    }
}
