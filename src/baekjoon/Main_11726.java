package baekjoon;

import java.io.*;
import java.math.BigInteger;

public class Main_11726 {

    static BigInteger[] dp2;
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        dp2 = new BigInteger[n+1];

        for (int i = 1; i < dp2.length; i++) {
            solution(i);
        }

        System.out.println(dp2[n].remainder(new BigInteger("10007")));
    }

    static void solution(int source) {
        BigInteger bigIntegerSource = new BigInteger(Integer.toString(source));
        if (bigIntegerSource.compareTo(new BigInteger("1")) == 0) {
            dp2[source] = new BigInteger("1");
            return;
        }
        if (bigIntegerSource.compareTo(new BigInteger("2")) == 0) {
            dp2[source] = new BigInteger("2");
        } else {
            dp2[source] = new BigInteger(dp2[source - 2].add(dp2[source - 1]).toString());
        }
    }
}
