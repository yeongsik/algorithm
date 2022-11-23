package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_6593 {

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

    static int l, r, c, time;
    static char[][][] building;
    static boolean[][][] isVisited;
    static final char START = 'S';
    static final char END = 'E';

    static final int[] DIRECTION_X = {0, 0, -1, 1, 0, 0};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0, 0, 0};
    static final int[] DIRECTION_Z = {0, 0, 0, 0, -1, 1};

    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    public static void main(String[] args) throws IOException {
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        while (true) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            l = Integer.parseInt(st.nextToken());
            r = Integer.parseInt(st.nextToken());
            c = Integer.parseInt(st.nextToken());

            building = new char[l][r][c];
            isVisited = new boolean[l][r][c];
            if (l == 0) {
                break;
            }

            makeBuilding();
            solution();

            if (time > 0) {
                bw.write("Escaped in " + time + " minute(s)." + "\n");
                time = 0;
            } else {
                bw.write("Trapped!" + "\n");
            }

        }
        bw.flush();
        bw.close();
    }

    static void makeBuilding() throws IOException {
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                char[] chars = br.readLine().toCharArray();
                for (int k = 0; k < c; k++) {
                    building[i][j][k] = chars[k];
                }
            }
            br.readLine();
        }
    }

    static void solution() {
        Queue<Point> queue = new LinkedList<>();
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < r; j++) {
                for (int k = 0; k < c; k++) {
                    if (building[i][j][k] == START) {
                        queue.add(new Point(k, j, i));
                        isVisited[i][j][k] = true;
                    }
                }
            }
        }
        bfs(queue);
    }

    static void bfs(Queue<Point> queue) {
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curP = queue.poll();

                for (int j = 0; j < 6; j++) {
                    Point nextP = new Point(curP.x + DIRECTION_X[j], curP.y + DIRECTION_Y[j], curP.z + DIRECTION_Z[j]);

                    if (!isValidArea(nextP)) {
                        continue;
                    }
                    if (building[nextP.z][nextP.y][nextP.x] == END) {
                        time = level+1;
                        return;
                    }
                    if (building[nextP.z][nextP.y][nextP.x] == '.' && !isVisited[nextP.z][nextP.y][nextP.x]) {
                        queue.add(nextP);
                        isVisited[nextP.z][nextP.y][nextP.x] = true;
                    }
                }
            }
            level++;
        }
    }

    static boolean isValidArea(Point point) {
        return point.x >= 0 && point.x < c
                && point.y >= 0 && point.y < r
                && point.z >= 0 && point.z < l;
    }
}
