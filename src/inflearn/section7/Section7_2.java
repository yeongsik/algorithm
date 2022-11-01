package inflearn.section7;

import java.io.*;

public class Section7_2 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        convertBinary(n);
        bw.flush();

        Section7_2 section7_2 = new Section7_2();
        section7_2.DFS(n);
        bw.flush();

    }

    static void convertBinary(int n) throws IOException {
        if (n / 2 == 1) {
            bw.write(n / 2 + "");
            bw.write(n % 2 + "");
            return;
        }
        convertBinary(n / 2);
        bw.write(n % 2 + "");
    }

    public void DFS(int n) throws IOException {
        if (n == 0) {
            return;
        }
        DFS(n / 2);
        bw.write(n % 2 + "");
    }
}
