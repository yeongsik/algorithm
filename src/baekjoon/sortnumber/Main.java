package baekjoon.sortnumber;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
 * 수 정렬하기 ( 2750번 )
 */
public class Main {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int first = scanner.nextInt();
        List<Integer> intArray = new ArrayList<>();
        while (intArray.size() < first) {
            intArray.add(scanner.nextInt());
        }
        Tool tool = new Tool();
        tool.sort(intArray);
        System.out.println("intArray = " + intArray.toString());
    }
}
class Tool {
    public void sort(List<Integer> intArray) {
        for (int i = 0; i < intArray.size()-1; i++) {
            int a = intArray.get(i);
            for ( int j = 1; j < intArray.size()-1; j++) {
                int b = intArray.get(j);
                if(a > b) {
                    intArray.remove(j);
                    intArray.remove(i);
                    intArray.add(i , b);
                    intArray.add(j , a);
                }
            }
        }
        for (int number : intArray) {
            System.out.println(number);
        }
    }
}
