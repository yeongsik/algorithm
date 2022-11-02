package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.Collections;
import java.util.StringTokenizer;

public class Main_1026 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        Integer[] a = makeArr(n, st);
        st = new StringTokenizer(br.readLine());
        Integer[] b = makeArr(n, st);

        Arrays.sort(a);
        Arrays.sort(b, Collections.reverseOrder());
        System.out.println(sum(a,b));

//        sort(a, false);
//        sort(b, true);
    }

    static Integer[] makeArr(int size, StringTokenizer contents) {
        Integer[] arr = new Integer[size];
        for (int i = 0; i < arr.length; i++) {
            arr[i] = Integer.parseInt(contents.nextToken());
        }
        return arr;
    }

    static Integer[] sort(Integer[] arr, boolean isReverse) {
        if (isReverse) {
            for (int i = 0; i < arr.length; i++) {

            }
        } else {
            for (int i = 0; i < arr.length; i++) {

            }
        }

        return arr;
    }
    static int sum(Integer[] a, Integer[] b) {
        int sum = 0;
        for (int i = 0; i < a.length; i++) {
            sum += a[i] * b[i];
        }
        return sum;
    }
}
