package programmers;

public class Prog43105 {
    public static void main(String[] args) {
        int[][] arr = {{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}};
        System.out.println(solution(arr));
    }

    static int solution(int[][] triangle) {

        int n = triangle.length;
        int[][] dp = new int[n][n];
        for (int i = 0; i < n; i++) {
            dp[n - 1][i] = triangle[n - 1][i];
        }

        for (int i = n - 2; i >= 0; i--) {
            for (int j = 0; j <= i; j++) {
                dp[i][j] = triangle[i][j] + Math.max(dp[i + 1][j], dp[i + 1][j + 1]);
            }
        }
        return dp[0][0];
    }
}
