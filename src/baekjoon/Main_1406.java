package baekjoon;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_1406 {
    static Stack<Character> leftFromCursor = new Stack<>();
    static Stack<Character> rightFromCursor = new Stack<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String str = br.readLine();
        int k = Integer.parseInt(br.readLine());
        for (char x : str.toCharArray()) {
            leftFromCursor.push(x);
        }
        for (int i = 0; i < k; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            solution(st);
        }

        int leftSize = leftFromCursor.size();
        for (int i = 0; i < leftSize; i++) {
            rightFromCursor.push(leftFromCursor.pop());
        }
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int rightSize = rightFromCursor.size();
        for (int i = 0; i < rightSize; i++) {
            bw.write(rightFromCursor.pop()+"");
        }
        bw.flush();
        bw.close();
    }

    static void solution(StringTokenizer input) {
        String command = input.nextToken();

        switch (command) {
            case "L":
                if (!leftFromCursor.isEmpty()) {
                    rightFromCursor.push(leftFromCursor.pop());
                }
                break;
            case "D":
                if (!rightFromCursor.isEmpty()) {
                    leftFromCursor.push(rightFromCursor.pop());
                }
                break;
            case "B":
                if (!leftFromCursor.isEmpty()) {
                    leftFromCursor.pop();
                }
                break;
            case "P":
                leftFromCursor.push(input.nextToken().charAt(0));
                break;
        }
    }
}
