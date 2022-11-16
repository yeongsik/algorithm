package inflearn.section10;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class Section10_4_lecture {
    static class Brick implements Comparable<Brick> {

        private int area;
        private int height;
        private int weight;

        public Brick(int area, int height, int weight) {
            this.area = area;
            this.height = height;
            this.weight = weight;
        }

        @Override
        public int compareTo(Brick o) {
            return o.area - this.area;
        }
    }
    static int[] dy;

    public int solution(ArrayList<Brick> arr) {
        Collections.sort(arr);
        dy[0] = arr.get(0).height;
        int answer = dy[0];
        for (int i = 1; i < arr.size(); i++) {
            int maxH = 0;
            for (int j = i - 1; j >= 0; j--) {
                if (arr.get(j).weight > arr.get(i).weight && dy[j] > maxH) {
                    maxH = dy[j];
                }
            }
            dy[i] = maxH + arr.get(i).height;
            answer = Math.max(answer, dy[i]);
        }
        return answer;
    }
    public static void main(String[] args) {
        Section10_4_lecture test = new Section10_4_lecture();
        Scanner kb = new Scanner(System.in);
        int n = kb.nextInt();
        ArrayList<Brick> arr = new ArrayList<>();
        dy = new int[n];
        for (int i = 0; i < n; i++) {
            int a = kb.nextInt();
            int b = kb.nextInt();
            int c = kb.nextInt();
            arr.add(new Brick(a, b, c));
        }
        System.out.println(test.solution(arr));
    }
}
