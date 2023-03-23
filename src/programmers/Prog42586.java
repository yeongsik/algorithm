package programmers;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class Prog42586 {
    public static void main(String[] args) {
        int[] progresses = {95, 90, 99, 99, 80, 99};
        int[] speeds = {1, 1, 1, 1, 1, 1};

        solution(progresses, speeds);
    }

    static int[] solution(int[] progresses, int[] speeds) {
        Queue<Integer> queue = new LinkedList<>();

        for (int i = 0; i < progresses.length; i++) {
            int time = (int) Math.ceil((100 - progresses[i]) / (double) speeds[i]);
            queue.add(time);
        }

        List<Integer> list = new ArrayList<>();

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();
            int cnt = 1;

            while (!queue.isEmpty() && cur >= queue.peek()) {
                queue.poll();
                cnt++;
            }
            list.add(cnt);
        }


        int[] answer = list.stream()
                .mapToInt(i -> i)
                .toArray();
        return answer;
    }
}
