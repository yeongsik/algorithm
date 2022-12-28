package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2579 {

    static int[][] dp;
    static int[] stairs;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp = new int[n + 1][3];
        stairs = new int[n + 1];
        for (int i = 1; i < n + 1; i++) {
            int input = Integer.parseInt(br.readLine());
            stairs[i] = input;
        }
        if (n < 2) {
            System.out.println(stairs[n]);
        } else {
            dp[1][1] = stairs[1];
            dp[2][1] = stairs[2];
            dp[2][2] = stairs[1] + stairs[2];

            for (int i = 2; i < n + 1; i++) {
                dp[i][2] = dp[i - 1][1] + stairs[i];
                dp[i][1] = Math.max(dp[i - 2][1] + stairs[i], dp[i - 2][2] + stairs[i]);
            }
            System.out.println(Math.max(dp[n][1] , dp[n][2]));
        }
    }
}
