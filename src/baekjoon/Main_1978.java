package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_1978 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());
        System.out.println(getPrimeNumCnt(n, st));

    }

    static int getPrimeNumCnt(int n, StringTokenizer st) {
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(st.nextToken());
            if(isPrimeNum(num)) {
                cnt++;
            }
        }
        return cnt;
    }

    static boolean isPrimeNum(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }
        return true;
    }
}
