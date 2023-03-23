package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Prog42583 {

    public static void main(String[] args) {
        int bridgeLength = 100;
        int weight = 100;
        int[] truckWeights = {10,10,10,10,10,10,10,10,10,10};

        System.out.println(solution(bridgeLength, weight, truckWeights));
    }

    static int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>();
        int time = 0;
        int idx = 0;
        int sum = 0;
        while (idx < truck_weights.length) {

            if (sum + truck_weights[idx] <= weight) {
                    queue.add(truck_weights[idx]);
                    sum += truck_weights[idx];
                    idx++;
                    time++;
            } else {
                queue.add(0);
                time++;
            }

            if (queue.size() == bridge_length) {
                Integer poll = queue.poll();
                sum -= poll;
            }

        }
        return time+bridge_length;
    }
}
