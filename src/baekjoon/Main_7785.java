package baekjoon;

import java.io.*;
import java.util.*;
import java.util.stream.Collectors;

public class Main_7785 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());

        Map<String, String> map = new HashMap<>();
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            map.put(st.nextToken(), st.nextToken());
        }

        List<String> working = new ArrayList<>();
        for (String key : map.keySet()) {
            String value = map.get(key);
            if (value.equals("enter")) {
                working.add(key);
            }
        }

        List<String> collect = working.stream().sorted(Comparator.reverseOrder()).collect(Collectors.toList());
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        for (String work : collect) {
            bw.write(work + "\n");
        }
        bw.flush();
        bw.close();
    }
}
