package programmers;


import java.util.HashMap;
import java.util.Map;

public class Pro20221005 {
    static String solution(String[] participant, String[] completion) {
        String answer = "";
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < participant.length; i++) {
            if (map.containsKey(participant[i])) {
                Integer k = map.get(participant[i]);
                map.put(participant[i], k + 1);
                continue;
            }
            map.put(participant[i], 1);
        }

        for (int i = 0; i < completion.length; i++) {
            Integer k = map.get(completion[i]);
            if (k > 0) {
                map.put(completion[i] , k-1);
            }
        }

        for (int i = 0; i < participant.length; i++) {
            Integer k = map.get(participant[i]);
            if (k > 0) {
                answer = participant[i];
                break;
            }
        }
        return answer;
    }
}
