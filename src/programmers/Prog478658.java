package programmers;

import java.awt.*;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class Prog478658 {

    static final int[] DIRECTION_X = {0, 0, -1, 1};
    static final int[] DIRECTION_Y = {-1, 1, 0, 0};

    static boolean[][] isVisited;
    public static void main(String[] args) {
        int m = 6;
        int n = 4;
        int[][] picture = {{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}};

        System.out.println(Arrays.toString(solution(m, n, picture)));

    }

    static int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[] answer = new int[2];
        isVisited = new boolean[m][n];

        for (int i = 0; i < m; i++) {
            for (int j = 0; j < n; j++) {
                if (!isVisited[i][j] && picture[i][j] != 0) {
                    isVisited[i][j] = true;
                    int cnt = bfs(i, j, m, n, picture);
                    if (cnt > 0) {
                        numberOfArea++;
                        maxSizeOfOneArea = Math.max(maxSizeOfOneArea, cnt);
                    }
                }

            }
        }

        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }

    static int bfs(int y, int x, int m, int n, int[][] picture) {
        Queue<Point> queue = new LinkedList<>();
        queue.add(new Point(x, y));
        int color = picture[y][x];
        int cnt = 1;
        while (!queue.isEmpty()) {
            Point curP = queue.poll();

            for (int i = 0; i < 4; i++) {
                Point nextP = new Point(curP.x + DIRECTION_X[i], curP.y + DIRECTION_Y[i]);

                if (nextP.x < 0 || nextP.x >= n || nextP.y < 0 || nextP.y >= m) {
                    continue;
                }

                if (isVisited[nextP.y][nextP.x] || picture[nextP.y][nextP.x] == 0 || picture[nextP.y][nextP.x] != color) {
                    continue;
                }

                isVisited[nextP.y][nextP.x] = true;
                queue.add(nextP);
                cnt++;
            }
        }

        return cnt;
    }
}
