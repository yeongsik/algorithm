package programmers;

import java.util.Stack;

public class Prog42584 {
    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 2, 3};

        solution(arr);
    }

    static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[stack.peek()] > prices[i]) {
                answer[stack.peek()] = i - stack.pop();
            }
            stack.push(i);
        }
        while (!stack.isEmpty()) {
            answer[stack.peek()] = prices.length - 1 - stack.pop();
        }
        return answer;
    }
}
