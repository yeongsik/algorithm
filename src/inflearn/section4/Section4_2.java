package inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Section4_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String strA = br.readLine();
        String strB = br.readLine();

        System.out.println(solution(strA,strB));
    }

    private static String solution(String strA, String strB) {
        Map<Character, Integer> mapA = convertToMap(strA);
        Map<Character, Integer> mapB = convertToMap(strB);

        for (char keyA : mapA.keySet()) {
            if (!mapB.containsKey(keyA)) {
                return "NO";
            } else {
                if (mapA.get(keyA) != mapB.get(keyA)) {
                    return "NO";
                }
            }
        }
        return "YES";
    }

    private static Map<Character, Integer> convertToMap(String str) {
        Map<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            map.put(x, map.getOrDefault(x, 0) + 1);
        }
        return map;
    }
}
