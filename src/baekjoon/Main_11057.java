package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_11057 {

    static final int DEVIDE = 10007;
    static int[][] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp(n);
        System.out.println(getSum(n));
    }

    static void dp(int n) {
        dy = new int[n + 1][10];
        for (int i = 0; i < 10; i++) {
            dy[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 1; j < 10; j++) {
                dy[i][0] = 1;
                dy[i][j] = (dy[i][j-1] + dy[i-1][j]) % DEVIDE;
            }
        }
    }

    static int getSum(int n) {
        int sum = 0;
        for (int x : dy[n]) {
            sum = sum + x;
            sum %= DEVIDE;
        }
        return sum;
    }
}
