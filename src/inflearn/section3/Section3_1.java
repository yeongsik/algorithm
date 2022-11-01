package inflearn.section3;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

/*
    두 배열 합치기 ( 투 포인터 알고리즘 )
 */
public class Section3_1 {

    static int n,m;
    static int[] a;
    static int[] b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        a = new int[n];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            a[i] = Integer.parseInt(st.nextToken());
        }

        m = Integer.parseInt(br.readLine());
        b = new int[m];
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < m; i++) {
            b[i] = Integer.parseInt(st.nextToken());
        }

        int p1 = 0;
        int p2 = 0;

        List<Integer> list = new ArrayList<>();
        while (p1 < n && p2 < m) {
            if (a[p1] < b[p2]) {
                list.add(a[p1++]);
            } else {
                list.add(b[p2++]);
            }
        }
        while (p1 < n) {
            list.add(a[p1++]);
        }

        while (p2 < m) {
            list.add(b[p2++]);
        }

        for (int a : list) {
            bw.write(a + " ");
        }

        bw.flush();
        bw.close();
    }

}
