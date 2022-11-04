package inflearn.section7;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

/*
    송아지 찾기
 */
public class Section7_8 {
    static int hyunsooPoint , cowPoint;
    static final int[] JUMP = {1, -1, 5};
    static boolean[] isVisited = new boolean[10001];

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        hyunsooPoint = Integer.parseInt(st.nextToken());
        cowPoint = Integer.parseInt(st.nextToken());

        System.out.println(BFS(hyunsooPoint));
    }

    static int BFS(int startPoint) {
        Queue<Integer> queue = new LinkedList<>();
        isVisited[startPoint] = true;
        queue.add(startPoint);
        int time = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curPoint = queue.poll();
                if (curPoint == cowPoint) {
                    return time;
                }
                for (int j = 0; j < JUMP.length; j++) {
                    int nextPoint = curPoint + JUMP[j];
                    if (isValidArea(nextPoint) && !isVisited[nextPoint]) {
                        isVisited[nextPoint] = true;
                        queue.add(nextPoint);
                    }
                }
            }
            time++;
        }
        return 0;
    }

    static boolean isValidArea(int point) {
        return point >= 1 && point <= 10000;
    }
}
