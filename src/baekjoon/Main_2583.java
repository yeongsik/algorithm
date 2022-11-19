package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;
import java.util.stream.Collectors;

public class Main_2583 {

    static int[][] arr;
    static boolean[][] isVisited;

    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};

    static int m, n, cnt;

    static List<Integer> emptyAreaList = new ArrayList<>();

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }

        public boolean isValidArea() {
            return x >= 0 && x < n && y >= 0 && y < m;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        m = Integer.parseInt(st.nextToken());
        n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        arr = new int[m][n];
        isVisited = new boolean[m][n];
        for (int i = 0; i < k; i++) {
            st = new StringTokenizer(br.readLine());
            Point startPoint = new Point(Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken()));
            Point endPoint = new Point(Integer.parseInt(st.nextToken()) - 1, Integer.parseInt(st.nextToken()) - 1);
            checkSquare(startPoint, endPoint);
        }

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && arr[i][j] == 0) {
                    emptyAreaList.add(bfs(new Point(j, i)));
                    cnt++;
                }
            }
        }
        System.out.println(cnt);

        for (int x : emptyAreaList.stream().sorted().collect(Collectors.toList())) {
            System.out.print(x + " ");
        }
    }

    private static int bfs(Point point) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(point);
        isVisited[point.y][point.x] = true;

        int cnt = 1;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                for (int j = 0; j < 4; j++) {
                    Point nextP = new Point(curPoint.x + DIRECTION_X[j], curPoint.y + DIRECTION_Y[j]);
                    if (nextP.isValidArea() && !isVisited[nextP.y][nextP.x] && arr[nextP.y][nextP.x] == 0) {
                        queue.add(nextP);
                        isVisited[nextP.y][nextP.x] = true;
                        cnt++;
                    }
                }
            }
        }
        return cnt;
    }

    private static void checkSquare(Point startPoint, Point endPoint) {
        for (int i = startPoint.y; i <= endPoint.y; i++) {
            for (int j = startPoint.x; j <= endPoint.x; j++) {
                arr[i][j]++;
                isVisited[i][j] = true;
            }
        }
    }

}
