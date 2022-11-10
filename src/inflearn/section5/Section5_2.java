package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section5_2 {

    public String solution(String str) {
        Stack<Character> stack = new Stack<>();
        StringBuilder sb = new StringBuilder();
        for (char c : str.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            }
            if (c == ')') {
                stack.pop();
            }
            if (stack.isEmpty() && c != ')') {
                sb.append(c);
            }
        }
        return sb.toString();
    }

    public String solutionFromLecture(String str) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (char x : str.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }
        return answer;
    }
    public static void main(String[] args) throws IOException {
        Section5_2 main = new Section5_2();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();
        System.out.println(main.solution(str));
        System.out.println(main.solutionFromLecture(str));
    }
}
