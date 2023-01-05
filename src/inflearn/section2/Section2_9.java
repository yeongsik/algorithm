package inflearn.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section2_9 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());

        int[][] arr = new int[n][n];

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                arr[i][j] = Integer.parseInt(st.nextToken());
            }
        }
        System.out.println(solution(arr));
    }

    static int solution(int[][] arr) {
        int max = 0;
        for (int i = 0; i < arr.length; i++) {
            int sumA = 0;
            int sumB = 0;
            int sumC = 0;
            for (int j = 0; j < arr.length; j++) {
                sumA += arr[i][j];
                sumB += arr[j][i];
                sumC += arr[j][j];
            }
            max = Math.max(max, sumA);
            max = Math.max(max, sumB);
            max = Math.max(max, sumC);
        }


        return max;
    }
}
