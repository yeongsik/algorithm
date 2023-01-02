package baekjoon;

import java.io.*;

public class Main_9461 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int t = Integer.parseInt(br.readLine());

        for (int i = 0; i < t; i++) {
            int n = Integer.parseInt(br.readLine());
            long[] dp = new long[n + 1];
            dp[1] = 1;

            if (n > 1) {
                dp[2] = 1;
            }

            if (n >= 3) {
                for (int j = 3; j < n + 1; j++) {
                    dp[j] = dp[j - 3] + dp[j - 2];
                }
            }
            bw.write(dp[n] + "\n");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
