package programmers;

public class Prog12911 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    static int solution(int n) {
        int nCnt = Integer.bitCount(n);

        while (true) {
            n++;
            if (nCnt == Integer.bitCount(n)) {
                return n;
            }
        }
    }
}
