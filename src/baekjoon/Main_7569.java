package baekjoon;


import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7569 {

    static int M , N , H , startTomatoCnt , emptyCnt , time;
    static int[][][] boxes;
    static boolean[][][] isVisited;
    static class Point {
        private int x;
        private int y;
        private int z;

        public Point(int x, int y, int z) {
            this.x = x;
            this.y = y;
            this.z = z;
        }
    }

    static final int[] DIRECTION_X = {-1, 1, 0, 0, 0, 0};
    static final int[] DIRECTION_Y = {0, 0, -1, 1, 0, 0};
    static final int[] DIRECTION_Z = {0, 0, 0, 0, -1, 1};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        M = Integer.parseInt(st.nextToken());
        N = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        boxes = new int[H][N][M];
        isVisited = new boolean[H][N][M];

        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                st = new StringTokenizer(br.readLine());
                for (int k = 0; k < M; k++) {
                    boxes[i][j][k] = Integer.parseInt(st.nextToken());
                    if (boxes[i][j][k] == 1) {
                        startTomatoCnt++;
                        queue.add(new Point(k, j, i));
                        isVisited[i][j][k] = true;
                    }
                    if (boxes[i][j][k] == -1) {
                        emptyCnt++;
                    }
                }
            }
        }

        int totalRoom = (N * M) * H;
        if (totalRoom - emptyCnt == startTomatoCnt) {
            System.out.println(0);
        } else {
            bfs(queue);
            if (!isDoneBoxes()) {
                System.out.println(-1);
            } else {
                System.out.println(time - 1);
            }
        }
    }

    static void bfs(Queue<Point> queue) {
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {

                Point cur = queue.poll();

                for (int j = 0; j < 6; j++) {
                    Point nextP = new Point(cur.x + DIRECTION_X[j], cur.y + DIRECTION_Y[j], cur.z + DIRECTION_Z[j]);

                    if (validArea(nextP) && !isVisited[nextP.z][nextP.y][nextP.x] && boxes[nextP.z][nextP.y][nextP.x] != -1) {
                        queue.add(nextP);
                        isVisited[nextP.z][nextP.y][nextP.x] = true;
                    }
                }
            }
            time++;
        }
    }

    static boolean validArea(Point point) {
        return point.x >= 0 && point.x < M && point.y >= 0 && point.y < N && point.z >= 0 && point.z < H;
    }

    static boolean isDoneBoxes() {
        boolean result = true;
        for (int i = 0; i < H; i++) {
            for (int j = 0; j < N; j++) {
                for (int k = 0; k < M; k++) {
                    if (boxes[i][j][k] == 0 && !isVisited[i][j][k]) {
                        return false;
                    }
                }
            }
        }
        return result;
    }
}
