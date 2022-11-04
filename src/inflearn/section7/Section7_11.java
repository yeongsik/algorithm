package inflearn.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section7_11 {

    static int n,m,cnt;
    static int[][] arr;
    static boolean[] isVisited;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken());
        m = Integer.parseInt(st.nextToken());

        arr = new int[n + 1][n + 1];
        isVisited = new boolean[n + 1];

        for (int i = 0; i < m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            arr[a][b] = 1;
        }
        isVisited[1] = true;
        DFS(1);
        System.out.println(cnt);
    }

    static void DFS(int now) {
        if (now == n) {
            cnt++;
            return;
        }

        for (int i = 0; i < n + 1; i++) {
            if (arr[now][i] == 1 && !isVisited[i]) {
                isVisited[i] = true;
                DFS(i);
                isVisited[i] = false;
            }
        }
    }
}
