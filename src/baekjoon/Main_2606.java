package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Main_2606 {

    static int computerSize;
    static List<Integer>[] computers;
    static boolean[] isInfected;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        computerSize = Integer.parseInt(br.readLine());
        computers = new List[computerSize + 1];
        isInfected = new boolean[computerSize + 1];

        for (int i = 0; i < computerSize + 1; i++) {
            computers[i] = new ArrayList<>();
        }

        int t = Integer.parseInt(br.readLine());
        for (int i = 0; i < t; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            computers[a].add(b);
            computers[b].add(a);
        }
        dfs(1);
        int cnt = 0;
        for (int i = 2; i < isInfected.length; i++) {
            if (isInfected[i]) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }

    static void dfs(int n) {
        if (isInfected[n]) {
            return;
        }
        isInfected[n] = true;
        for (int connectedCom : computers[n]) {
            dfs(connectedCom);
        }
    }
}
