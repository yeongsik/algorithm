package programmers;

public class Prog12945 {
    public static void main(String[] args) {

    }
    public int solution(int n) {
        int[] f = new int[n + 1];

        f[0] = 0;
        f[1] = 1;
        for (int i = 2; i < f.length; i++) {
            f[i] = (f[i - 2] + f[i - 1]) % 1234567;
        }
        return f[n];
    }
}
