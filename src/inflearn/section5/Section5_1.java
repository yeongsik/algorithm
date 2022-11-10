package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section5_1 {
    public String solution(String str) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }
                stack.pop();
            }
        }
        if (!stack.isEmpty()) {
            answer = "NO";
        }

        return answer;
    }
    public static void main(String[] args) throws IOException {
        Section5_1 main = new Section5_1();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(main.solution(br.readLine()));
    }
}
