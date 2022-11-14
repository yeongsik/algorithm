package inflearn.section4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class Section4_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int n = Integer.parseInt(br.readLine());
        String str = br.readLine();

        Map<Character, Integer> map = new HashMap<>();
        for (char x : str.toCharArray()) {
            if (map.containsKey(x)) {
                map.put(x, map.get(x) + 1);
            } else {
                map.put(x, 1);
            }
        }
        System.out.println(getResult(map));

    }

    static char getResult(Map<Character, Integer> map) {
        char x = 'x';
        int max = 0;
        for (char c : map.keySet()) {
            if (max < map.get(c)) {
                max = map.get(c);
                x = c;
            }
        }
        return x;
    }
}
