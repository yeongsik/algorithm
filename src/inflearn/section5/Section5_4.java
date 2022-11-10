package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section5_4 {

    static final String PLUS = "+";
    static final String MINUS = "-";
    static final String MULTIPLY = "*";
    static final String DIVIDE = "/";

    public int solution(String str) {
        Stack<Integer> stack = new Stack<>();

        String[] split = str.split("");
        for (String s : split) {
            if (s.equals(PLUS) || s.equals(MINUS) || s.equals(MULTIPLY) || s.equals(DIVIDE)) {
                int a = stack.pop();
                int b = stack.pop();
                stack.push(calculate(a, b, s));
            } else {
                stack.push(Integer.parseInt(s));
            }
        }

        return  stack.pop();
    }

    private int calculate(int a, int b, String s) {
        switch (s) {
            case PLUS: return Math.abs(a + b);
            case MINUS: return Math.abs(a - b);
            case MULTIPLY: return Math.abs(a * b);
            default: return Math.abs(a / b);
        }
    }

    public static void main(String[] args) throws IOException {
        Section5_4 main = new Section5_4();

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        System.out.println(main.solution(br.readLine()));
    }
}
