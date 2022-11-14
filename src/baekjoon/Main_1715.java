package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.PriorityQueue;


/*
    경계범위 생각하기
    우선순위 큐 정렬되는 거 생각하자
 */
public class Main_1715 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int i = 0; i < n; i++) {
            pq.add(Integer.parseInt(br.readLine()));
        }
        int cnt = 0;

        while (!pq.isEmpty() && pq.size() != 1) {
            int tmp = pq.poll() + pq.poll();
            pq.add(tmp);
            cnt += tmp;
        }
        System.out.println(cnt);
    }
}
