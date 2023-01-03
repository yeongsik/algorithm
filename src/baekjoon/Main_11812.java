package baekjoon;

import java.io.*;
import java.util.*;

public class Main_11812 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        long n = Long.parseLong(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        int q = Integer.parseInt(st.nextToken());

        for (int i = 0; i < q; i++) {
            st = new StringTokenizer(br.readLine());
            long a = Long.parseLong(st.nextToken());
            long b = Long.parseLong(st.nextToken());

            if (k == 1) {
                bw.write(Math.abs(a-b) + "\n");
                continue;
            }

            int distance = 0;
            while (a != b) {
                long max = Math.max(a, b);
                b = Math.min(a, b);
                a = (max - 2) / k + 1; // k진트리에서 부모 찾는 식
                distance++;
            }
            bw.write(distance + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
