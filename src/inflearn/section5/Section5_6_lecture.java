package inflearn.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section5_6_lecture {

    public int solution(int n, int k) {
        int answer = 0;
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 1; i <= n; i++) {
            queue.offer(i);
        }
        while (!queue.isEmpty()) {
            for (int i = 1; i < k; i++) {
                queue.offer(queue.poll());
            }
            queue.poll();
            if (queue.size() == 1) {
                answer = queue.poll();
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Section5_6_lecture main = new Section5_6_lecture();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        int k = kb.nextInt();
        System.out.println(main.solution(n,k));
    }
}
