package inflearn.section5;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class Section5_3 {

    static int n;
    static Stack<Integer>[] stackArr;
    static int[][] board;

    public int solution(int[] moves) {
        int cnt = 0;
        Stack<Integer> basket = new Stack<>();
        for (int move : moves) {
            if (stackArr[move].isEmpty()) {
            } else {
                int popDoll = stackArr[move].pop();
                if (basket.isEmpty()) {
                    basket.push(popDoll);
                } else {
                    if (basket.peek() == popDoll) {
                        basket.pop();
                        cnt += 2;
                    } else {
                        basket.push(popDoll);
                    }
                }
            }
        }
        return cnt;
    }

    public static void main(String[] args) throws IOException {
        Section5_3 main = new Section5_3();
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        n = Integer.parseInt(br.readLine());
        board = new int[n][n];
        stackArr = new Stack[n + 1];
        for (int i = 0; i < n + 1; i++) {
            stackArr[i] = new Stack<>();
        }

        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            for (int j = 0; j < n; j++) {
                board[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        for (int i = n - 1; i >= 0; i--) {
            for (int j = 0; j < n; j++) {
                if (board[i][j] != 0) {
                    stackArr[j + 1].push(board[i][j]);
                }
            }
        }

        int[] moves = new int[Integer.parseInt(br.readLine())];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < moves.length; i++) {
            moves[i] = Integer.parseInt(st.nextToken());
        }
        System.out.println(main.solution(moves));
    }
}
