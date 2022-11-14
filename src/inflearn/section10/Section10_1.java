package inflearn.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class Section10_1 {
    static int cnt;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        DFS(1,n);
        DFS(2,n);

        System.out.println(cnt);
    }

    static void DFS(int sum, int end) {
        if (sum == end) {
            cnt++;
            return;
        }
        if (sum > end) {
            return;
        }
        DFS(sum + 1, end);
        DFS(sum + 2, end);
    }
}
