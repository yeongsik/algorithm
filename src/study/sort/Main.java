package study.sort;

import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        int[] intArray = new int[scanner.nextInt()];

        for(int i =0; i<intArray.length; i++) {
            intArray[i] = scanner.nextInt();
        }
        for ( int i =0; i < intArray.length; i++) {
            for ( int n = 0; n<intArray.length-(1+i); n++) {
                if(intArray[n] > intArray[n+1]) {
                    int temp = intArray[n];
                    intArray[n] = intArray[n+1];
                    intArray[n+1] = temp;
                }
            }
        }
        for ( int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
