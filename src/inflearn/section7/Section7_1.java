package inflearn.section7;

import java.io.*;

public class Section7_1 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        recursive(1,n);
        bw.flush();

        Section7_1 section = new Section7_1();

        section.DFS(n);

        bw.flush();
    }

    static void recursive(int cnt, int size) throws IOException {
        if (cnt > size) {
            return;
        }
        bw.write(cnt + " ");
        recursive(cnt+1,size);
    }

    public void DFS(int n) throws IOException {
        if(n == 0) {
            return;
        }
        DFS(n - 1);
        bw.write(n + " ");
    }
}
