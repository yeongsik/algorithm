package inflearn.section8;

import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class Section8_5_lecture {
    static int n,m,answer = Integer.MAX_VALUE;
    public void DFS(int L, int sum, Integer[] arr) {
        if (sum > m) {
            return;
        }
        if (L >= answer) {
            return;
        }
        if (sum == m) {
            answer = Math.min(answer, L);
        } else {
            for (int i = 0; i < n; i++) {
                DFS(L + 1, sum + arr[i], arr);
            }
        }
    }
    public static void main(String[] args) {
        Section8_5_lecture main = new Section8_5_lecture();
        Scanner kb = new Scanner(System.in);
        n = kb.nextInt();
        Integer[] arr = new Integer[n];
        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());
        m = kb.nextInt();
        main.DFS(0, 0, arr);
        System.out.println(answer);
    }
}
