package inflearn.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section5_7_lecture {

    public String solution(String need, String plan) {
        String answer = "YES";
        Queue<Character> queue = new LinkedList<>();

        for (char c : need.toCharArray()) {
            queue.offer(c);
        }

        for (char c : plan.toCharArray()) {
            if (queue.contains(c)) {
                if (c != queue.poll()) {
                    return "NO";
                }
            }
        }
        if (!queue.isEmpty()) {
            return "NO";
        }
        return answer;
    }

    public static void main(String[] args) {
        Section5_7_lecture main = new Section5_7_lecture();
        Scanner kb = new Scanner(System.in);
        String a = kb.next();
        String b = kb.next();
        System.out.println(main.solution(a, b));
    }
}
