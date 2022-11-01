package inflearn.section7;

import java.io.*;

public class Section7_4 {

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
        if (n == 1) {
            return fibo[n] = 1;
        }
        if (n == 2) {
            return fibo[n] = 1;
        }
        return fibo[n] = dfs(n - 2) + dfs(n - 1);
    }
}
