package inflearn.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section2_5 {
    static int[] ch;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        ch = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i < ch.length; i++) {
            if (ch[i] == 0) {
                cnt++;
            }
            int j = 1;
            while (i * j <= n) {
                ch[i * j] = 1;
                j++;
            }
        }

        System.out.println(cnt);
    }
}
