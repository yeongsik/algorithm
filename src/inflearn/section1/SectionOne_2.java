package inflearn.section1;

import java.io.*;

public class SectionOne_2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        char[] chars = br.readLine().toCharArray();

        for (char c : chars) {
            if (c >= 65 && c <= 90) {
                c += 32;
                bw.write(c +"");
                continue;
            }
            if (c >= 97 && c <= 122) {
                c -= 32;
                bw.write(c +"");
            }
        }
        bw.flush();
        bw.close();
    }
}
