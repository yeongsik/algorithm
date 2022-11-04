package baekjoon;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_1697 {
    static boolean[] isVisited = new boolean[100001];
    static int[] moves = {-1, 1, 2};
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int soobinPoint = Integer.parseInt(st.nextToken());
        int brotherPoint = Integer.parseInt(st.nextToken());

        System.out.println(getShortCut(soobinPoint, brotherPoint));
    }

    static int getShortCut(int soobinPoint, int brotherPoint) {
        Queue<Integer> queue = new LinkedList<>();

        queue.add(soobinPoint);
        isVisited[soobinPoint] = true;

        int level = 0;
        while (!queue.isEmpty()) {
            int len = queue.size();
            for (int i = 0; i < len; i++) {
                int curPoint = queue.poll();
                if (curPoint == brotherPoint) {
                    return level;
                }

                for (int j = 0; j < moves.length; j++) {
                    int nextPoint = curPoint + moves[j];
                    if (moves[j] == 2) {
                        nextPoint = curPoint * moves[j];
                    }

                    if (isValidArea(nextPoint) && !isVisited[nextPoint]) {
                        queue.add(nextPoint);
                        isVisited[nextPoint] = true;
                    }
                }
            }
            level++;
        }
        return 0;
    }
    static boolean isValidArea(int point) {
        return point >= 0 && point <= 100000;
    }
}
