package inflearn.section10;

import java.util.Scanner;

public class Section10_1_lecture {

    static int[] dy;

    public int solution(int n) {
        dy[1] = 1;
        dy[2] = 2;
        for (int i = 3; i <= n; i++) {
            dy[i] = dy[i - 1] + dy[i - 2];
        }
        return dy[n];
    }
    public static void main(String[] args) {
        Section10_1_lecture main = new Section10_1_lecture();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        dy = new int[n + 1];
        System.out.println(main.solution(n));
    }
}
