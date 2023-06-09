package baekjoon;

import java.io.*;
import java.util.*;

public class Main_13414 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int k = Integer.parseInt(st.nextToken());
        int length = Integer.parseInt(st.nextToken());

        Map<String, Integer> map = new LinkedHashMap<>();
        Queue<String> queue = new LinkedList<>();
        for (int i = 0; i < length; i++) {
            String input = br.readLine();

            if (!map.containsKey(input)) {
                map.put(input, 1);
            } else {
                map.remove(input);
                map.put(input,1);
            }
        }

        List<String> keys = new ArrayList<>(map.keySet());


        for (int i = 0; i < k; i++) {
            if (i >= keys.size()) {
                break;
            }
            bw.write(keys.get(i) + "\n");
        }

        bw.flush();
        bw.close();
    }
}
