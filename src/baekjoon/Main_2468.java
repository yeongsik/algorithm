package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2468 {

    static int[][] area;
    static boolean[][] isVisited;
    static int size,cnt;
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
        size = Integer.parseInt(br.readLine());

        area = new int[size][size];

        for (int i = 0; i < size; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < size; j++) {
                area[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int precipitation = 0; precipitation < 100; precipitation++) {
            isVisited = new boolean[size][size];
            int curCnt = 0;
            for (int i = 0; i < size; i++) {
                for (int j = 0; j < size; j++) {
                    if (!isVisited[i][j] && area[i][j] > precipitation) {
                        BFS(new Point(j,i) , precipitation);
                        curCnt++;
                    }
                }
            }
            cnt = Math.max(cnt, curCnt);
        }
        System.out.println(cnt);
    }

    static void BFS(Point startPoint, int precipitation) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        isVisited[startPoint.y][startPoint.x] = true;

        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                Point curPoint = queue.poll();

                for (int j = 0; j < 4; j++) {
                    int nextX = curPoint.x + DIRECTION_X[j];
                    int nextY = curPoint.y + DIRECTION_Y[j];

                    Point nextPoint = new Point(nextX, nextY);
                    if (isValidArea(nextPoint) && !isVisited[nextY][nextX] && area[nextY][nextX] > precipitation) {
                        queue.add(nextPoint);
                        isVisited[nextY][nextX] = true;
                    }
                }
            }
        }
    }

    static boolean isValidArea(Point point) {
        return point.x >= 0 && point.x < size && point.y >= 0 && point.y < size;
    }
}
