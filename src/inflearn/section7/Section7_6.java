package inflearn.section7;

import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;

public class Section7_6 {
    static int n;
    static int[] ch;
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
    public void DFS(int L) throws IOException {
        if (L == n + 1) {
            StringBuilder sb = new StringBuilder();
            for (int i = 0; i <= n; i++) {
                if (ch[i] == 1) {
                    sb.append(i + " ");
                }
            }
            if (sb.length() > 0) {
                bw.write(sb.toString() + "\n");
            }
        } else {
            ch[L] = 1;
            DFS(L + 1);
            ch[L] = 0;
            DFS(L + 1);
        }
    }
    public static void main(String[] args) throws IOException {
        Section7_6 main = new Section7_6();
        n=3;
        ch = new int[n + 1];
        main.DFS(1);
        bw.flush();
        bw.close();
    }
}
