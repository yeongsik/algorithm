package programmers;

import java.util.LinkedList;
import java.util.Queue;

public class Prog43162 {

    static int networkCnt;
    static boolean[] visited;

    public static void main(String[] args) {
        int[][] ex = {{1, 1, 0}, {1, 1, 0}, {0, 0, 1}};
        System.out.println(solution(3,ex));
    }
    static int solution(int n, int[][] computers) {
        visited = new boolean[n];

        for (int i = 0; i < n; i++) {
            if(!visited[i]) {
                bfs(i,computers);
            }
        }

        return networkCnt;
    }

    private static void bfs(int computer,int[][] coms) {
        Queue<Integer> queue = new LinkedList<>();
        queue.add(computer);
        visited[computer] = true;

        while (!queue.isEmpty()) {
            Integer cur = queue.poll();

            for (int i = 0; i < coms[cur].length; i++) {
                if (!visited[i] && coms[cur][i] == 1) {
                    queue.add(i);
                    visited[i] = true;
                }
            }
        }

        networkCnt++;
    }
}
