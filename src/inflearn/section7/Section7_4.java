package inflearn.section7;

import java.io.*;

public class Section7_4 {

    /*
        피보나치 수열 재귀로도 구현할 수도 있고 for문으로도 구현할 수 있다.
        메모이제이션을 사용하면 더 빠르게 구현 가능
     */
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int[] fibo;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        fibo = new int[n + 1];
        dfs(n);

        for (int x : fibo) {
            bw.write(x + " ");
        }
        bw.flush();
    }

    static int dfs(int n) {
        if (fibo[n] > 0) {
            return fibo[n];
        }
        if (n == 1) {
            return fibo[n] = 1;
        }
        if (n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }
}
