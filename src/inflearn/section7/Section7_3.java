package inflearn.section7;

import java.io.*;

public class Section7_3 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    static int result;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        result = 1;
        factorial(n);
        bw.write(result +"");
        bw.flush();


        Section7_3 section7_3 = new Section7_3();
        System.out.println(section7_3.DFS(5));

    }

    static void factorial(int n) {
        if (n == 0) {
            return;
        }
        result *= n;
        factorial(n - 1);
    }

    public int DFS(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n * DFS(n - 1);
        }
    }
}
