package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_14503_3 {

    static int[][] rooms;
    static boolean[][] isCleaned;
    static int n,m, r,c,direction,cleanCnt,turnCnt;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        rooms = new int[n][m];
        isCleaned = new boolean[n][m];

        st = new StringTokenizer(br.readLine());
        r = Integer.parseInt(st.nextToken());
        c = Integer.parseInt(st.nextToken());
        direction = Integer.parseInt(st.nextToken());

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < m; j++) {
                rooms[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        while (true) {
            isCleaned[r][c] = true;

            if (isNotWallToLeft()) {
                if (!isCleanToLeft()) {
                    turnLeft();
                    moveForward();
                    continue;
                }
            }

            turnLeft();

            if (turnCnt == 4) {
                if (isPossibleGoBackward()) {
                    moveBackward();
                    continue;
                }
                break;
            }
        }

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if (isCleaned[i][j]) {
                    cleanCnt++;
                }
            }
        }

        System.out.println(cleanCnt);
    }

    static boolean isCleanToLeft() {
        switch (direction) {
            case 0 : return isCleaned[r][c-1];
            case 1 : return isCleaned[r-1][c];
            case 2 : return isCleaned[r][c+1];
            case 3 : return isCleaned[r+1][c];
        }
        return false;
    }

    static boolean isNotWallToLeft() {
        switch (direction) {
            case 0 : return rooms[r][c-1] == 0;

            case 1 : return rooms[r-1][c] == 0;

            case 2 : return rooms[r][c+1] == 0;

            case 3 : return rooms[r+1][c] == 0;

        }
        return false;
    }
    static void turnLeft() {
        direction--;
        if (direction < 0) {
            direction = 3;
        }
        turnCnt++;
    }

    static void moveForward() {
        switch (direction) {
            case 0: r--;
                break;
            case 1: c++;
                break;
            case 2: r++;
                break;
            case 3: c--;
                break;
        }
        turnCnt = 0;
    }

    static boolean isPossibleGoBackward() {
        switch (direction) {
            case 0:
                return rooms[r+1][c] == 0;
            case 1:
                return rooms[r][c-1] == 0;
            case 2:
                return rooms[r-1][c] == 0;
            case 3:
                return rooms[r][c+1] == 0;
        }
        return false;
    }

    private static void moveBackward() {
        switch (direction) {
            case 0: r++;
                break;
            case 1: c--;
                break;
            case 2: r--;
                break;
            case 3: c++;
                break;
        }
        turnCnt = 0;
    }
}
