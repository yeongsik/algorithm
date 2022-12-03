package baekjoon;

import java.io.*;
import java.util.StringTokenizer;

public class Main_11659 {

    static int N,M;
    static int[] arr;
    static int[] dy;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        init(st);

        st = new StringTokenizer(br.readLine());
        setData(st);
        solution(br, bw);
        bw.flush();
        bw.close();
    }

    private static void solution(BufferedReader br, BufferedWriter bw) throws IOException {
        StringTokenizer st;
        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int start = Integer.parseInt(st.nextToken());
            int end = Integer.parseInt(st.nextToken());

            bw.write(dy[end] - dy[start-1] + "\n");
        }
    }

    private static void setData(StringTokenizer st) {
        for (int i = 1; i < N + 1; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
            if (i == 1) {
                dy[i] = arr[i];
            } else {
                dy[i] = dy[i - 1] + arr[i];
            }
        }
    }

    private static void init(StringTokenizer st) {
        N = Integer.parseInt(st.nextToken());
        M= Integer.parseInt(st.nextToken());

        arr = new int[N + 1];
        dy = new int[N + 1];
    }
}
