package inflearn.section1;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SectionOne_1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String word = br.readLine().toUpperCase();
        String str = br.readLine().toUpperCase();

        char[] chars = word.toCharArray();
        int cnt = 0;
        for (char c : chars) {
            if (str.equals(String.valueOf(c))) {
                cnt++;
            }
        }
        System.out.println(cnt);
    }
}
