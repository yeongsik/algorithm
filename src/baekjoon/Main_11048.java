package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_11048 {
    static int n, m;
    static class Point{
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValidArea() {
            return this.x >= 1 && this.x < m + 1 && this.y >= 1 && this.y < n + 1;
        }
    }
    static int[][] dy;
    static boolean[][] isVisited;
    static int[][] arr;
    static final int[] DIRECTION_X = {0, 1, 1};
    static final int[] DIRECTION_Y = {1, 0, 1};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][m + 1];
        dy = new int [n + 1][m + 1];
        isVisited = new boolean[n + 1][m + 1];

        for (int i = 0; i < arr.length; i++) {
            Arrays.fill(dy[i], Integer.MIN_VALUE);
        }
        for (int i = 1; i < n + 1; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 1; j < m + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(new Point(1, 1)));

    }

    static int solution(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;
        dy[point.y][point.x] = arr[point.y][point.x];

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();

                for (int j = 0; j < 3; j++) {
                    Point nextP = new Point(curPoint.x + DIRECTION_X[j], curPoint.y + DIRECTION_Y[j]);
                    if (nextP.isValidArea()) {
                        if (!isVisited[nextP.y][nextP.x]) {
                            queue.add(nextP);
                            isVisited[nextP.y][nextP.x] = true;
                        }
                        int sum = dy[curPoint.y][curPoint.x] + arr[nextP.y][nextP.x];
                        dy[nextP.y][nextP.x] = Math.max(dy[nextP.y][nextP.x], sum);
                    }
                }
            }
        }
        return dy[n][m];
    }
}
