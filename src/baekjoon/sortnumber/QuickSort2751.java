package baekjoon.sortnumber;

import java.util.Scanner;

public class QuickSort2751 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] intArray = new int[scanner.nextInt()];
        int i = 0;
        while(i < intArray.length) {
            intArray[i] = scanner.nextInt();
            i++;
        }

    }

    private void quickSort(int[] arr) {
        quickSort(arr , 0 , arr.length-1);
    }

    private void quickSort(int[] arr, int start, int end) {

    }

    private void printIntArr(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
