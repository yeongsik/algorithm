package inflearn.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section10_2 {
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n + 2];
        System.out.println(solution(n+1));

    }

    static int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;

        for (int i = 3; i < dy.length; i++) {
            dy[i] = dy[i - 2] + dy[i - 1];
        }
        return dy[n];
    }
}
