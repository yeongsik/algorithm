package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_1912 {

    static int[] arr;
    static int[] dy;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = init(br);
        setData(br, n);
        dp(n);
    }

    private static void dp(int n) {
        dy[0] = arr[0];
        int max = dy[0];
        for (int i = 1; i < n; i++) {
            dy[i] = Math.max(dy[i-1] + arr[i], arr[i]);
            max = Math.max(max, dy[i]);
        }
        System.out.println(max);
    }

    private static void setData(BufferedReader br, int n) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }
    }

    private static int init(BufferedReader br) throws IOException {
        int n = Integer.parseInt(br.readLine());
        arr = new int[n];
        dy = new int[n];
        return n;
    }
}
