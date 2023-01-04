package inflearn.section2;

import java.io.*;
import java.util.StringTokenizer;

public class Section2_8 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];
        int[] order = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            int cnt = 1;
            for (int j = 0; j < n; j++) {
                if (arr[i] < arr[j]) {
                    cnt++;
                }
            }
            order[i] = cnt;
        }

        for (int k : order) {
            bw.write(k + " ");
        }
        bw.flush();
        bw.close();
        br.close();

    }
}
