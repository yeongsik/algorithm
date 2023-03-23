package programmers;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Prog12906 {
    public static void main(String[] args) {
        int[] ex = {1, 1, 3, 3, 0, 1, 1};
        System.out.println(solution(ex));
    }

    static int[] solution(int []arr) {

        Stack<Integer> stack = new Stack<>();

        stack.push(arr[0]);
        for (int i = 1; i < arr.length; i++) {
            if (stack.peek() != arr[i]) {
                stack.push(arr[i]);
            }
        }

        int[] answer = new int[stack.size()];
        for (int i = answer.length-1; i >= 0; i--) {
            answer[i] = stack.pop();
        }
        return answer;
    }
}
