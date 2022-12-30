package baekjoon;

import java.io.*;

class Count {
    int zeroCnt;
    int OneCnt;

    public Count(int zeroCnt, int oneCnt) {
        this.zeroCnt = zeroCnt;
        OneCnt = oneCnt;
    }
}

public class Main_1003 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            int n = Integer.parseInt(br.readLine());
            Count[] dp = new Count[n + 1];
            dp[0] = new Count(1, 0);

            if (n > 0) {
                dp[1] = new Count(0, 1);
            }

            if (n > 1) {
                for (int j = 2; j < dp.length; j++) {
                    dp[j] = new Count(dp[j - 2].zeroCnt + dp[j - 1].zeroCnt, dp[j - 2].OneCnt + dp[j - 1].OneCnt);
                }
            }
            bw.write(dp[n].zeroCnt + " " + dp[n].OneCnt + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
