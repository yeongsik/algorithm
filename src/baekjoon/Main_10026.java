package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Main_10026 {

    static int n;
    static char[][] field;
    static boolean[][] isVisited;
    static final char RED = 'R';
    static final char BLUE = 'B';
    static final char GREEN = 'G';

    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValidArea() {
            return x >= 0 && x < n && y >= 0 && y < n;
        }
    }
    static final boolean IS_COLOR_WEAKNESS = true;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        field = new char[n][n];
        isVisited = new boolean[n][n];

        for (int i = 0; i < n; i++) {
            char[] chars = br.readLine().toCharArray();
            for (int j = 0; j < n; j++) {
                field[i][j] = chars[j];
            }
        }
        int cnt = 0;
        List<Integer> cntList = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    BFS(new Point(j, i) , !IS_COLOR_WEAKNESS);
                    cnt++;
                }
            }
        }
        cntList.add(cnt);
        isVisited = new boolean[n][n];
        cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j]) {
                    BFS(new Point(j, i), IS_COLOR_WEAKNESS);
                    cnt++;
                }
            }
        }
        cntList.add(cnt);

        for (int x : cntList) {
            System.out.print(x + " ");
        }
    }

    static void BFS(Point point, boolean isColerWeekness) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;
        char curColor = field[point.y][point.x];
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();

                for (int j = 0; j < 4; j++) {
                    Point nextPoint = new Point(curPoint.x + DIRECTION_X[j], curPoint.y + DIRECTION_Y[j]);
                    if (nextPoint.isValidArea() && !isVisited[nextPoint.y][nextPoint.x]) {
                        char nextColor = field[nextPoint.y][nextPoint.x];
                        if (isColerWeekness) {
                            if (curColor == BLUE && nextColor == BLUE) {
                                queue.add(nextPoint);
                                isVisited[nextPoint.y][nextPoint.x] = true;
                                continue;
                            }
                            if (curColor == RED || curColor == GREEN) {
                                if (nextColor == GREEN || nextColor == RED) {
                                    queue.add(nextPoint);
                                    isVisited[nextPoint.y][nextPoint.x] = true;
                                }
                            }
                        } else {
                            if (curColor == nextColor) {
                                queue.add(nextPoint);
                                isVisited[nextPoint.y][nextPoint.x] = true;
                            }
                        }
                    }
                }
            }
        }
    }
}
