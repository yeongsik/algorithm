package baekjoon;

import java.io.*;
import java.util.Collections;
import java.util.PriorityQueue;

public class Main_11279 {
    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < n; i++) {
            solution(Integer.parseInt(br.readLine()), pq);
        }
        bw.flush();
        bw.close();
    }

    static void solution(int input , PriorityQueue<Integer> pq) throws IOException {
        if (input == 0) {
            if(pq.isEmpty()) {
                bw.write(0 + "\n");
            } else {
                bw.write(pq.poll() + "\n");
            }
        } else {
            pq.add(input);
        }
    }
}
