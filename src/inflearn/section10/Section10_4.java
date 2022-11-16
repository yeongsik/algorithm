package inflearn.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Section10_4 {
    static int[] dy;

    static class Rectangle {

        private int area;
        private int height;
        private int weight;

        public Rectangle(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Rectangle[] recArr = new Rectangle[n];
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            recArr[i] = new Rectangle(area, height, weight);
        }

        dy[0] = recArr[0].height;
        for (int i = 1; i < n; i++) {
            int max = recArr[i].height;
            for (int j = i - 1; j >= 0; j--) {
                if (recArr[j].area > recArr[i].area && recArr[j].weight > recArr[i].weight) {
                    max = Math.max(max, dy[j] + recArr[i].height);
                }
            }
            dy[i] = max;
        }
        int answer = 0;
        for (int i : dy) {
            answer = Math.max(answer, i);
        }
        System.out.println(answer);
    }
}
