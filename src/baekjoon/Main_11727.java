package baekjoon;

import java.util.Scanner;

public class Main_11727 {
    static int[] dy;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        System.out.println(solution(n));
    }

    static int solution(int n) {
        dy = new int[n+1];
        dy[1] = 1;
        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                dy[i] = (dy[i - 1] * 2 + 1) % 10007;
            } else {
                dy[i] = (dy[i - 1] * 2 - 1) % 10007;
            }
        }
        return dy[n];
    }
}
