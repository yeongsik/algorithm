package programmers;

import java.util.*;

public class Prog42587 {
    public static void main(String[] args) {
        int[] ex1 = {2, 1, 3, 2};
        int location1 = 2;
        int[] ex2 = {1, 1, 9, 1, 1, 1};
        int location2 = 0;

        System.out.println(solution(ex1,location1));
        System.out.println(solution(ex2,location2));

    }

    static int solution(int[] priorities, int location) {
        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < priorities.length; i++) {
            pq.add(priorities[i]);
        }

        int order = 0;
        while (!pq.isEmpty()) {
            for (int i = 0; i < priorities.length; i++) {
                if (pq.peek() == priorities[i]) {
                    if (location == i) {
                        order++;
                        return order;
                    }
                    pq.poll();
                    order++;
                }
            }
        }
        return order;
    }

}
