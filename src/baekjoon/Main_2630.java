package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Main_2630 {

    static int[][] paper;
    static int n,whitePaperCnt,bluePaperCnt;
    public static void main(String[] args) throws IOException {
        BufferedReader in = new BufferedReader(new InputStreamReader(System.in));

        n = Integer.parseInt(in.readLine());
        paper = new int[n][n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(in.readLine());
            for (int j = 0; j < n; j++) {
                paper[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        dfs(0, 0, n);
        System.out.println(whitePaperCnt);
        System.out.println(bluePaperCnt);
    }

    static void dfs(int x, int y, int length) {
        int blueCnt = 0;
        int whiteCnt = 0;
        int paperSize = 0;
        for (int i = x; i < x+length; i++) {
            for (int j = y; j < y+length; j++) {
                paperSize++;
                if (paper[i][j] == 0) {
                    whiteCnt++;
                }
                if (paper[i][j] == 1) {
                    blueCnt++;
                }
            }
        }
        if (blueCnt == paperSize) {
            bluePaperCnt++;
            return;
        }
        if (whiteCnt == paperSize) {
            whitePaperCnt++;
            return;
        }
        dfs(x, y, length/2);
        dfs(x+length/2, y, length/2);
        dfs(x, y+length/2, length/2);
        dfs(x+length/2, y+length/2, length/2);
    }
}
