package baekjoon.sortnumber;

import java.util.List;
import java.util.Scanner;

/*
 * 수 정렬하기 ( 2750번 )
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int[scanner.nextInt()];

        for ( int i = 0; i < array.length; i++) {
            array[i] = scanner.nextInt();
        }
        selectSort(array);

        for ( int value : array ) {
            System.out.println(value);
        }
    }
    private static int[] selectSort(int[] intArray) {
        for(int i = 0 ; i < intArray.length-1; i ++) {
            for ( int j = i+1 ; j < intArray.length; j ++) {
                // i 와 나머지 j 들이 비교
                // i 가 큰 경우 j 와 i 의 값 위치 변경
                if(intArray[i] > intArray[j] ) {
                    int temp = intArray[j];
                    intArray[j] = intArray[i];
                    intArray[i] = temp;
                }
            }
        }
        return intArray;
    }

}

