package baekjoon.factorial;

import java.util.Scanner;

public class Answer {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int num = scanner.nextInt();
        System.out.println(fact(num));
    }

    public static int fact(int number) {
        if ( number <= 1 ) {return 1;}
        return fact(number-1) * number;
    }
}



