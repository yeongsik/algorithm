package inflearn.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section2_4 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        long[] fibo = new long[n + 1];
        for (int i = 1; i < fibo.length; i++) {
            if (i == 1) {
                fibo[i] = 1;
            } else {
                fibo[i] = fibo[i - 2] + fibo[i - 1];
            }
        }
        System.out.println(fibo[n]);
    }
}
