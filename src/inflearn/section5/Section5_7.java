package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;

public class Section5_7 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Queue<Character> queue = new LinkedList<>();
        char[] lectures = br.readLine().toCharArray();

        for (char lecture : lectures) {
            queue.add(lecture);
        }

        String str = br.readLine();
        int idx = 0;

        while (!queue.isEmpty()) {
            char peek = queue.peek();
            int i = str.indexOf(peek);
            if (i >= 0) {
                if (idx > i) {
                    System.out.println("NO");
                    break;
                } else {
                    idx = i;
                    queue.poll();
                }
            } else {
                System.out.println("NO");
                break;
            }
        }

        if (queue.isEmpty()) {
            System.out.println("YES");
        }
    }
}
