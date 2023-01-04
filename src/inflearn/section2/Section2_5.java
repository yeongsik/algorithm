package inflearn.section2;

import java.io.*;

public class Section2_5 {
    static int[] ch;
    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        ch = new int[n + 1];
        int cnt = 0;
        for (int i = 2; i < ch.length; i++) {
            if (ch[i] == 0) {
                bw.write(i + " ");
                cnt++;

                for (int j = i; j <= n; j = j + i) {
                    ch[j] = 1;
                }
            }

        }
        bw.write("\n");
        bw.write(cnt + "");

        bw.flush();
        bw.close();
        br.close();
    }
}
