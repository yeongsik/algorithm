package programmers;

import java.util.Arrays;

public class Prog12939 {
    public static void main(String[] args) {
        solution("-1 -2 -3 -4");
    }
    static String solution(String s) {
        String[] s1 = s.split(" ");
        int[] intArr = new int[s1.length];

        for (int i = 0; i < intArr.length; i++) {
            intArr[i] = Integer.parseInt(s1[i]);
        }

        Arrays.sort(intArr);
        StringBuilder sb = new StringBuilder();
        sb.append(intArr[0] + " " + intArr[intArr.length-1]);
        String s2 = sb.toString();

        return s2;
    }
}
