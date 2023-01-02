package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main_1932 {

    static int[][] dp;
    static int[][] triangle;

    static int n;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());

        dp = new int[n][n];
        triangle = new int[n][n];

        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {

            }
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < i + 1; j++) {
                triangle[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        System.out.println(dfs(0, 0));
    }

    static int dfs(int depth, int idx) {
        if (depth == n - 1) {
            return dp[depth][idx];
        }

        if (dp[depth][idx] == 0) {
            dp[depth][idx] = Math.max(dfs(depth + 1, idx), dfs(depth + 1, idx + 1)) + triangle[depth][idx];
        }

        return dp[depth][idx];
    }
}
