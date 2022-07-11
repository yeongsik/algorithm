package baekjoon.factorial;

import java.util.Scanner;
/*
팩토리얼 ( 10872번 )
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int number = scanner.nextInt();
        if (number >= 0 && number <= 12) {
            int result = number;
            if(result == 0) {
                System.out.println(1);
            } else {
                for (int i=1; i<number-1; i++) {
                    result = result * (number - i);
                }
                System.out.println(result);
            }
        }
    }
}
