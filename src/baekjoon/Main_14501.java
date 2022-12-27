package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_14501 {
    static int n;
    static int[] days;
    static int[] prices;
    static int[] dp;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        dp = new int[n + 1];
        days = new int[n + 1];
        prices = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            days[i] = Integer.parseInt(st.nextToken());
            prices[i] = Integer.parseInt(st.nextToken());
        }

        int max = 0;
        for (int i = 1; i < n + 1; i++) {
            if (i + days[i] > n + 1) {
                dp[i] = 0;
                continue;
            }
            for (int j = i - 1; j >= 0; j--) {
                if (days[j] + j <= i) {
                    dp[i] = Math.max(dp[i], prices[i] + dp[j]);
                } else {
                    dp[i] = Math.max(dp[i], prices[i]);
                }
            }
            max = Math.max(max, dp[i]);
        }
        System.out.println(max);
    }
}
