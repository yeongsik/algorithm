package inflearn.section10;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class Section10_4 {
    static int[] dy;

    static class Rectangle implements Comparable<Rectangle> {


        private int area;
        private int height;
        private int weight;

        public Rectangle(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Rectangle o) {
            return o.area - this.area;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        Rectangle[] recArr = new Rectangle[n];
        List<Rectangle> list = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int area = Integer.parseInt(st.nextToken());
            int height = Integer.parseInt(st.nextToken());
            int weight = Integer.parseInt(st.nextToken());
            recArr[i] = new Rectangle(area, height, weight);
            list.add(new Rectangle(area, height, weight));
        }

        list.sort(Rectangle::compareTo);

        dy[0] = list.get(0).height;
        for (int i = 1; i < n; i++) {
            int max = list.get(i).height;
            Rectangle pointerRec = list.get(i);
            for (int j = i - 1; j >= 0; j--) {
                if (list.get(j).weight > pointerRec.weight) {
                    max = Math.max(max, dy[j] + pointerRec.height);
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
