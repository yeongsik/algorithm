package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Section5_6 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < n; i++) {
            queue.add(i + 1);
        }
        int start = 1;
        while (queue.size() > 1) {
            while (start != k) {
                int tmp = queue.poll();
                queue.add(tmp);
                start++;
            }
            if (start == k) {
                queue.poll();
                start = 1;
            }
        }
        System.out.println(queue.poll());
    }
}
