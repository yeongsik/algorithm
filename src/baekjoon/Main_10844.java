package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_10844 {
    static long[][] dy;
    static int n;
    static final int DIVIDE = 1000000000;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(br.readLine());
        init();
        dp();
        System.out.println(getAnswer());
    }

    private static long getAnswer() {
        long sum = 0;
        for (long x : dy[n]) {
            sum += x;
        }
        return sum % DIVIDE;
    }

    private static void dp() {
        for (int i = 2; i < n +1; i++) {
            for (int j = 0; j < 10; j++) {
                if (j == 0) {
                    dy[i][j] = dy[i-1][j+1] % DIVIDE;
                    continue;
                }
                if (j == 9) {
                    dy[i][j] = dy[i-1][j-1] % DIVIDE;
                    continue;
                }
                dy[i][j] = (dy[i - 1][j - 1] % DIVIDE) + (dy[i - 1][j + 1] % DIVIDE);
            }
        }
    }

    private static void init() {
        dy = new long[n +1][10];
        for (int i = 1; i < 10; i++) {
            dy[1][i] = 1;
        }
    }
}
