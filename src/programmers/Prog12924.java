package programmers;

public class Prog12924 {
    public static void main(String[] args) {
        System.out.println(solution(15));
    }

    static int solution(int n) {
        int sum = 0;
        int cnt = 0;
        for (int i = 0; i < n; i++) {
            for (int j = i+1; i < n; j++) {
                sum += j;
                if (sum == n) {
                    cnt++;
                    sum = 0;
                    break;
                }
                if (sum > n) {
                    sum = 0;
                    break;
                }
            }
        }
        return cnt;
    }
}
