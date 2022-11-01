package inflearn.section3;

import java.io.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class Section3_2 {

    static int n, m;
    static int[] a, b;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        a = makeArr(n, st);

        m = Integer.parseInt(br.readLine());
        st = new StringTokenizer(br.readLine());
        b = makeArr(m, st);

        for (int element : makeSameElementArr(a, b)) {
            bw.write(element + " ");
        }
        bw.flush();
        bw.close();
    }

    static int[] makeArr(int size, StringTokenizer input) {
        int[] arr = new int[size];
        for (int i = 0; i < size; i++) {
            arr[i] = Integer.parseInt(input.nextToken());
        }
        Arrays.sort(arr);
        return arr;
    }

    static List<Integer> makeSameElementArr(int[] a, int[] b) {
        List<Integer> list = new ArrayList<>();
        int p1 = 0;
        int p2 = 0;

        while (p1 < a.length && p2 < b.length) {
            if (a[p1] == b[p2]) {
                list.add(a[p1]);
                p1++;
                p2++;
                continue;
            }
            if (a[p1] < b[p2]) {
                p1++;
                continue;
            }
            if (a[p1] > b[p2]) {
                p2++;
            }
        }
        return list;
    }
}
