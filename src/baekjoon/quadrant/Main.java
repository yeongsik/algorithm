package baekjoon.quadrant;

import java.util.Scanner;

/*
백준 14681 문제
사분면 고르기
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int x = scanner.nextInt();
        int y = scanner.nextInt();
        Tool tool = new Tool();
        System.out.println(tool.calulateQuadrant(x, y));

    }
}


class Tool {
    public int calulateQuadrant(int x , int y) {
        int Quadrant = 0;
        if(x > 0 ) {
            if( y > 0) Quadrant = 1;
            if( y < 0) Quadrant = 4;
        }
        if(x < 0) {
            if (y > 0) Quadrant = 2;
            if (y < 0) Quadrant = 3;
        }
        return Quadrant;
    }
}

