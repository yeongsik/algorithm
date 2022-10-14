package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_2636 {

    static int[][] board;
    static boolean[][] visited;
    static int[] directX = {-1, 1, 0, 0};
    static int[] directY = {0, 0, -1, 1};

    static int x,y,cnt;

    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(in.readLine());
        x = Integer.parseInt(st.nextToken());
        y = Integer.parseInt(st.nextToken());
        board = new int[x][y];
        visited = new boolean[x][y];

        for (int i = 0; i < x; i++) {
            st = new StringTokenizer(in.readLine());
            for (int j = 0; j < y; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int time = 0;
        while (existCheeseOnBoard()) {
            visited = new boolean[x][y];
            checkCheeseEdge();
            deleteCheeseEdges();
            time++;

        }
        System.out.println(time);
        System.out.println(cnt);
    }

    static boolean existCheeseOnBoard() {
        boolean result = false;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if(board[i][j] == 1)
                    result = true;
            }
        }
        return result;
    }

    static void checkCheeseEdge() {
        Queue<int[]> queue = new LinkedList<>();
        visited[0][0] = true;
        queue.add(new int[]{1,1});

        while (!queue.isEmpty()) {
            int[] point = queue.poll();
            int px = point[0];
            int py = point[1];

            if (board[px][py] == 2) {
                continue;
            }

            for (int i = 0; i < 4; i++) {
                int nx = px + directX[i];
                int ny = py + directY[i];
                if (nx < 0 || nx > x-1 || ny < 0 || ny > y-1)
                    continue;
                if (!visited[nx][ny]) {
                    visited[nx][ny] = true;
                    if (board[nx][ny] == 1) {
                        board[nx][ny] = 2;
                    }
                    queue.add(new int[]{nx, ny});
                }

            }
        }
    }

    static void deleteCheeseEdges() {
        cnt = 0;
        for (int i = 0; i < x; i++) {
            for (int j = 0; j < y; j++) {
                if (board[i][j] == 2) {
                    board[i][j] = 0;
                    cnt++;
                }
            }
        }
    }

}
