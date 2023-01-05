package inflearn.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section2_10 {

    static int[][] arr;

    static final int[] D_X = {0, 0, 1, -1};
    static final int[] D_Y = {1, -1, 0, 0};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new int[n + 2][n + 2];

        for (int i = 1; i < n + 1; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 1; j < n + 1; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        int cnt = 0;
        for (int i = 1; i < n + 1; i++) {
            for (int j = 1; j < n + 1; j++) {
                if (isPeak(i,j)) {
                    cnt++;
                }
            }
        }
        System.out.println(cnt);
    }

    static boolean isPeak(int row,int col) {
        for (int i = 0; i < 4; i++) {
            int side = arr[row + D_Y[i]][col + D_X[i]];
            if (side >= arr[row][col]) {
                return false;
            }
        }
        return true;
    }
}
