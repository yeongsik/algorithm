package inflearn.section2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section2_7 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        int[] arr = new int[n];

        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i] = Integer.parseInt(st.nextToken());
        }

        System.out.println(solution(arr));
    }

    static int solution(int[] arr) {

        int seq = 0;
        int answer = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 1) {
                answer += arr[i] + seq;
                seq++;
            } else {
                seq = 0;
            }
        }
        return answer;
    }
}
