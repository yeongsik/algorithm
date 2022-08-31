package baekjoon.dfs;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.Set;

public class N2210 {

    static final int numberBoardMaxIndex = 5;
    static int[][] numberBoard = new int[numberBoardMaxIndex][numberBoardMaxIndex];
    static int[] directionX = {-1, 1, 0, 0};
    static int[] directionY = {0, 0, -1, 1};
    static Set<String> numberSet = new HashSet<String>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        // 숫자판 입력
        for (int i = 0; i < numberBoardMaxIndex; i++) {
            String[] s = br.readLine().split(" ");
            for (int j = 0; j < numberBoardMaxIndex; j++) {
                numberBoard[i][j] = Integer.parseInt(s[j]);
            }
        }
        String numberCombination = new String(); // String pool 의 과부하를 방지하기 위해 따로 Stirng 참조 객체 생성 후 전달
        for (int i = 0; i < numberBoardMaxIndex; i++) {
            for (int j = 0; j < numberBoardMaxIndex; j++) {
                addNumberCombination(i,j,0,numberCombination);
            }
        }
        System.out.println(numberSet.size());
    }

    public static void addNumberCombination(int x, int y, int size, String numberCombination) {

        // 탈출조건1 6자리 수가 되면 중복되지 않은 set에 넣고 리턴
        if (size == 6) {
            numberSet.add(numberCombination);
            return;
        }

        // 분기조건 x , y 좌표 각 방향에 움직임
        for (int i = 0; i < 4; i++) {
            int nextX = x + directionX[i];
            int nextY = y + directionY[i];

            // 탈출조건2
            if (nextX < 0 || nextX >= numberBoardMaxIndex || nextY < 0 || nextY >= numberBoardMaxIndex) {
                continue;
            }
            addNumberCombination(nextX,nextY,size+1,numberCombination+numberBoard[x][y]);
        }
    }
}
