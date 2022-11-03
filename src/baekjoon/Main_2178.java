package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2178 {

    static int N,M;
    static int[][] maze;
    static int[][] distance;
    static boolean[][] isVisited;
    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};
    static class Point {
        private int x;
        private int y;
        private int distance;
        public Point(int y, int x, int distance) {
            this.y = y;
            this.x = x;
            this.distance = distance;
        }
    }
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        maze = new int[N][M];
        distance = new int[N][M];

        isVisited = new boolean[N][M];

        for (int i = 0; i < N; i++) {
            String[] inputs = br.readLine().split("");
            for (int j = 0; j < M; j++) {
                maze[i][j] = Integer.parseInt(inputs[j]);
            }
        }
        BFS(0, 0);
        System.out.println(distance[N - 1][M - 1]);
    }

    static void BFS(int y, int x) {
        int dist = 1;
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(y,x,dist));
        isVisited[y][x] = true;
        while (!queue.isEmpty()) {
            Point curPoint = queue.poll();

            if (distance[curPoint.y][curPoint.x] == 0) {
                distance[curPoint.y][curPoint.x] = curPoint.distance;
            }

            for (int i = 0; i < 4; i++) {
                int nextY = curPoint.y + DIRECTION_Y[i];
                int nextX = curPoint.x + DIRECTION_X[i];

                if (!isValidArea(nextY, nextX)) {
                    continue;
                }
                if (!isVisited[nextY][nextX] && maze[nextY][nextX] != 0) {
                    queue.add(new Point(nextY, nextX,curPoint.distance+1));
                    isVisited[nextY][nextX] = true;
                }
            }
        }
    }
    static boolean isValidArea(int y, int x) {
        return y >= 0 && y < N && x >= 0 && x < M;
    }
}
