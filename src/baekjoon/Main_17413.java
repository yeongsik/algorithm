package baekjoon;

import java.io.*;
import java.util.Stack;

public class Main_17413 {

    static BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String str = br.readLine();

        char[] chars = str.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == '<') {
                while (chars[i] != '>') {
                    bw.write(chars[i]);
                    i++;
                }
                bw.write(">");
            } else {
                StringBuilder sb = new StringBuilder();
                while (chars[i] != '<') {
                    sb.append(chars[i]);
                    i++;

                    if (i >= chars.length) {
                        break;
                    }
                }
                String[] s = sb.toString().split(" ");

                for (int j = 0; j < s.length; j++) {
                    reverseStr(s[j]);
                    if (j < s.length - 1) {
                        bw.write(" ");
                    }
                }

                i--;
            }
        }

        bw.flush();
        bw.close();
    }

    static void reverseStr(String str) throws IOException {
        Stack<Character> stack = new Stack<>();
        char[] chars = str.toCharArray();

        for (int i = 0; i < chars.length; i++) {
            stack.push(chars[i]);
        }

        while (!stack.isEmpty()) {
            bw.write(stack.pop() + "");
        }
    }
}
