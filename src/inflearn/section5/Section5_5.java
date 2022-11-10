package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class Section5_5 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        Stack<Character> stack = new Stack<>();
        int cnt = 0;
        for (char x : str.toCharArray()) {
            if (!stack.isEmpty() && x == ')' && stack.peek() == '(') {
                stack.pop();
                stack.push('L');
                continue;
            }
            if (stack.isEmpty()) {
                stack.push(x);
                continue;
            }
            if (!stack.isEmpty() && x == ')' && stack.peek() == 'L') {
                int lazorCnt = 0;
                while (stack.peek() == 'L') {
                    lazorCnt++;
                    stack.pop();
                }
                stack.pop();
                for (int i = 0; i < lazorCnt; i++) {
                    stack.push('L');
                }
                cnt += lazorCnt + 1;
            } else {
                stack.push(x);
            }
        }
        System.out.println(cnt);
    }
}
