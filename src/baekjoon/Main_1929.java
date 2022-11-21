package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1929 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int m = Integer.parseInt(st.nextToken());
        int n = Integer.parseInt(st.nextToken());
        int[] arr = new int[n+1];

        for (int i = 2; i < n+1; i++) {
            int operate = i;
            int j = 2;
            while (operate <= n) {
                operate = i * j;
                if (operate <= n && arr[operate] == 0) {
                    arr[operate] = 1;
                }
                j++;
            }
        }
        for (int i = m; i <= n; i++) {
            if (i == 1) {
                continue;
            }
            if (arr[i] == 0) {
                bw.write(i + "\n");
            }
        }
        bw.flush();
        bw.close();
    }
}
