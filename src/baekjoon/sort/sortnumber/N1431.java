package baekjoon.sort.sortnumber;

import java.io.*;
import java.util.Arrays;

/*
    다솜이는 기타를 많이 가지고 있다. 그리고 각각의 기타는 모두 다른 시리얼 번호를 가지고 있다.
    다솜이는 기타를 빨리 찾아서 빨리 사람들에게 연주해주기 위해서 기타를 시리얼 번호 순서대로 정렬하고자 한다.
    모든 시리얼 번호는 알파벳 대문자 (A-Z)와 숫자 (0-9)로 이루어져 있다.
    시리얼번호 A가 시리얼번호 B의 앞에 오는 경우는 다음과 같다.
    1.A와 B의 길이가 다르면, 짧은 것이 먼저 온다.
    2.만약 서로 길이가 같다면, A의 모든 자리수의 합과 B의 모든 자리수의 합을 비교해서 작은 합을 가지는 것이 먼저온다. (숫자인 것만 더한다)
    3.만약 1,2번 둘 조건으로도 비교할 수 없으면, 사전순으로 비교한다. 숫자가 알파벳보다 사전순으로 작다.
    시리얼이 주어졌을 때, 정렬해서 출력하는 프로그램을 작성하시오.
*/
public class N1431 {
    private static String[] guitarSerialNumbers;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        guitarSerialNumbers = new String[Integer.parseInt(br.readLine())];

        for(int i =0; i<guitarSerialNumbers.length; i++) {
            guitarSerialNumbers[i] = br.readLine();
        }

        Arrays.sort(guitarSerialNumbers, (o1, o2) -> {
            if(o1.length() != o2.length()) {
                return o1.length() - o2.length();
            }

            if(o1.length() == o2.length()) {
                // 두개의 스트링 값 숫자만 추출
                char[] charsA = o1.replaceAll("[^0-9]", "").toCharArray();
                int sumA = 0;
                for (char a : charsA) {
                    sumA += Character.digit(a,10);
                }
                char[] charsB = o2.replaceAll("[^0-9]", "").toCharArray();
                int sumB = 0;
                for (char b : charsB) {
                    sumB += Character.digit(b,10);
                }
                if (sumA != sumB) {
                    return sumA - sumB;
                }
            }
            return o1.compareTo(o2);
        });

        br.close();

        for(String serialNumber : guitarSerialNumbers) {
            bw.write(serialNumber + "\n");
        }

        bw.flush();

    }
}
