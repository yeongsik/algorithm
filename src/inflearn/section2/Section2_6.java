package inflearn.section2;

import java.io.*;
import java.util.StringTokenizer;

public class Section2_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine());

        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 0; i < n; i++) {
            int num = convertToInt(st);
            if (num == 1) {
                continue;
            }

            if (isPrime(num)) {
                bw.write(num + " ");
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }

    static boolean isPrime(int num) {
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

    static int convertToInt(StringTokenizer st) {
        String s = st.nextToken();
        StringBuilder sb = new StringBuilder(s);
        s = sb.reverse().toString();

        while (s.charAt(0) == '0') {
            s = s.replaceFirst(String.valueOf(s.charAt(0)), "");
        }
        return Integer.parseInt(s);
    }
}
