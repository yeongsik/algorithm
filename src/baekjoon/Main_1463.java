package baekjoon;

import java.util.Scanner;

// https://www.acmicpc.net/problem/1463
public class Main_1463 {
    static int[] dy;
    public static void main(String[] args) {
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        dy[1] = 0;
        for (int i = 2; i < n + 1; i++) {
            int min = Integer.MAX_VALUE;
            if (i % 2 == 0) {
                min = Math.min(min, dy[i / 2] + 1);
            }
            if (i % 3 == 0) {
                min = Math.min(min, dy[i / 3] + 1);
            }
            min = Math.min(min, dy[i - 1] + 1);
            dy[i] = min;
        }
        System.out.println(dy[n]);
    }
}
