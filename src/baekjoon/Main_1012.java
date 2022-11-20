package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1012 {

    static int m, n, k;
    static int[][] field;
    static boolean[][] isVisited;
    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
    static final int CABBAGE = 1;
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        private boolean isValidArea() {
            return x >= 0 && x < m && y >= 0 && y < n;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int testCaseSize = Integer.parseInt(br.readLine());
        List<Integer> bugsList = new ArrayList<>();
        for (int i = 0; i < testCaseSize; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            m = Integer.parseInt(st.nextToken());
            n = Integer.parseInt(st.nextToken());
            k = Integer.parseInt(st.nextToken());

            field = new int[n][m];
            isVisited = new boolean[n][m];

            for (int j = 0; j < k; j++) {
                st = new StringTokenizer(br.readLine());
                int x = Integer.parseInt(st.nextToken());
                int y = Integer.parseInt(st.nextToken());
                field[y][x] = 1;
            }

            bugsList.add(checkCntWhiteBug());
        }

        for (int x : bugsList) {
            System.out.println(x);
        }
    }

    private static int checkCntWhiteBug() {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (!isVisited[i][j] && field[i][j] == CABBAGE) {
                    bfs(new Point(j, i));
                    cnt++;
                }
            }
        }
        return cnt;
    }

    static void bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Point nextP = new Point(curPoint.x + DIRECTION_X[j], curPoint.y + DIRECTION_Y[j]);

                    if (nextP.isValidArea() && !isVisited[nextP.y][nextP.x] && field[nextP.y][nextP.x] == CABBAGE) {
                        queue.add(nextP);
                        isVisited[nextP.y][nextP.x] = true;
                    }
                }
            }
        }
    }
}