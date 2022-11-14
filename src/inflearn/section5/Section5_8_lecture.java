package inflearn.section5;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class Section5_8_lecture {
    static class Person {
        int id;
        int priority;

        public Person(int id, int priority) {
            this.id = id;
            this.priority = priority;
        }

    }

    public int solution(int n, int m, int[] arr) {
        int answer = 0;
        Queue<Person> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(new Person(i, arr[i]));
        }
        while (!queue.isEmpty()) {
            Person tmp = queue.poll();
            for (Person x : queue) {
                if (x.priority > tmp.priority) {
                    queue.add(tmp);
                    tmp = null;
                    break;
                }
            }
            if (tmp != null) {
                answer++;
                if (tmp.id == m) {
                    return answer;
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {
        Section5_8_lecture main = new Section5_8_lecture();
        Scanner kb = new Scanner(System.in);

        int n = kb.nextInt();
        int m = kb.nextInt();
        int[] arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = kb.nextInt();
        }
        System.out.println(main.solution(n,m,arr));
    }
}
