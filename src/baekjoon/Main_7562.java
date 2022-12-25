package baekjoon;

import java.io.*;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class Main_7562 {

    static class Point {
        private int x;
        private int y;

        public Point(int x, int y) {
            this.x = x;
            this.y = y;
        }
    }

    static int chessSize;

    static Point startPoint;
    static Point destinationPoint;
    static int[][] chessArr;
    static final int[] moveX = {-2,-2,2,2,1,-1,1,-1};
    static final int[] moveY = {1,-1,1,-1,2,2,-2,-2};

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        int testCase = Integer.parseInt(br.readLine());

        for (int i = 0; i < testCase; i++) {
            chessSize = Integer.parseInt(br.readLine());
            chessArr = new int[chessSize][chessSize];

            startPoint = makePoint(br);
            destinationPoint = makePoint(br);

            bw.write(bfs() + "\n");
        }
        bw.flush();
        bw.close();
    }

    static Point makePoint(BufferedReader br) throws IOException {
        StringTokenizer st = new StringTokenizer(br.readLine());

        int x = Integer.parseInt(st.nextToken());
        int y = Integer.parseInt(st.nextToken());

        return new Point(x, y);
    }

    static int bfs() {
        Queue<Point> queue = new LinkedList<>();
        queue.add(startPoint);
        chessArr[startPoint.y][startPoint.x] = 1;
        int level = 0;
        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                Point curPoint = queue.poll();
                if (isMatched(curPoint, destinationPoint)) {
                    return level;
                }
                for (int j = 0; j < moveX.length; j++) {
                    Point nextPoint = new Point(curPoint.x + moveX[j], curPoint.y + moveY[j]);
                    if (isValid(nextPoint) && chessArr[nextPoint.y][nextPoint.x] == 0) {
                        queue.add(nextPoint);
                        chessArr[nextPoint.y][nextPoint.x] = level+1;
                    }
                }
            }
            level++;
        }
        return -1;
    }

    static boolean isMatched(Point point, Point destinationPoint) {
        return point.x == destinationPoint.x && point.y == destinationPoint.y;
    }

    static boolean isValid(Point point) {
        return point.x >= 0 && point.x < chessSize && point.y >= 0 && point.y < chessSize;
    }
}
