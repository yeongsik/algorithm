package programmers;
import java.util.HashMap;
import java.util.Map;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/42578
 */
public class Pro20221101 {

    public static void main(String[] args) {
        String[][] test =new String[][]{{"yellow_hat", "headgear"}, {"blue_sunglasses", "eyewear"}, {"green_turban", "headgear"}};
        baekjoon.Main_1012 main = new baekjoon.Main_1012();
        System.out.println(main.solution(test));
    }

    public int solution(String[][] clothes) {
        int answer = 1;

        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < clothes.length; i++) {
            if (map.containsKey(clothes[i][1])) {
                map.put(clothes[i][1], map.get(clothes[i][1]) + 1);
            } else {
                map.put(clothes[i][1], 1);
            }
        }

        for (String key : map.keySet()) {
            int size = map.get(key);
            answer = answer * (size + 1);
        }
        return answer-1;
    }
}
