package inflearn.section4;

import java.util.HashMap;
import java.util.Scanner;

public class Section4_1_lecture {
    public char solution(int n, String s) {
        char answer = ' ';
        HashMap<Character, Integer> map = new HashMap<>();
        for (char x : s.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        int max = Integer.MIN_VALUE;
        for (char key : map.keySet()) {
            if (map.get(key) > max) {
                max = map.get(key);
                answer = key;
            }
        }
        return answer;
    }
    public static void main(String[] args) {
        Section4_1_lecture main = new Section4_1_lecture();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        String str = kb.next();
        System.out.println(main.solution(n, str));
    }
}
