package programmers;

import java.util.Stack;

public class Prog12973 {
    public static void main(String[] args) {
        System.out.println(solution("baabaa"));
    }

    static int solution(String s) {
        Stack<Character> stack = new Stack<>();
        char[] chars = s.toCharArray();
        int answer = 0;
        stack.push(chars[0]);
        for (int i = 1; i < s.length(); i++) {
            if (!stack.isEmpty()) {
                if (stack.peek() == chars[i]) {
                    stack.pop();
                    continue;
                }
            }
            stack.push(chars[i]);
        }

        if (stack.isEmpty()) {
            answer = 1;
        }

        return answer;
    }
}
