package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_11055 {

    static int dy[];
    static int arr[];
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dy = new int[n];
        arr = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            dy[i] = arr[i];
        }
        dp();
    }

    static void dp() {
        dy[0] = arr[0];
        int result = dy[0];
        for (int i = 1; i < arr.length; i++) {
            for (int j = i - 1; j >= 0; j--) {
                if (arr[i] > arr[j]) {
                    dy[i] = Math.max(dy[i], arr[i]+dy[j]);
                }
            }
            result = Math.max(result, dy[i]);
        }
        System.out.println(result);
    }
}
