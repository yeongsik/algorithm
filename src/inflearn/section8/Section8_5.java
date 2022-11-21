package inflearn.section8;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Section8_5 {

    static int k;
    static Integer[] arr;

    static int cnt = Integer.MAX_VALUE;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        arr = new Integer[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
        Arrays.sort(arr, Collections.reverseOrder());
        k = Integer.parseInt(br.readLine());
        dfs(0, 0);
        System.out.println(cnt);

    }

    static void dfs(int sum, int size) {
        if (size >= cnt) {
            return;
        }
        if (sum > k) {
            return;
        }

        if (sum == k) {
            cnt = Math.min(cnt,size);
            return;
        }
        for (int i = 0; i < arr.length; i++) {
            dfs(sum + arr[i], size + 1);
        }
    }
}
