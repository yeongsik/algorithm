package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Main_2747 {
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        System.out.println(solution(n));
    }

    static int solution(int n) {
        dy = new int[n+1];
        dy[0] = 0;
        dy[1] = 1;

        for (int i = 2; i < dy.length; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }
}
