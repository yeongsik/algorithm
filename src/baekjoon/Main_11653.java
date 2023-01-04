package baekjoon;

import java.io.*;

public class Main_11653 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int n = Integer.parseInt(br.readLine());

        int i = 2;
        while (n != 1) {
            if (n % i == 0) {
                bw.write(i + "\n");
                n = n / i;
                i = 2;
            } else {
                i++;
            }
        }
        bw.flush();
        bw.close();
        br.close();
    }
}
