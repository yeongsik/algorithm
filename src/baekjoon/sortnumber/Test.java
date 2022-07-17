package baekjoon.sortnumber;

import java.util.Scanner;

public class Test {

    private static void selectionSort(int[] arr) {
        selectionSort(arr , 0);
    }
    private static void selectionSort(int[] arr , int start) {
        if ( start < arr.length -1) {
            int min_index = start;
            for (int i = start; i < arr.length; i ++) {
                if (arr[i] < arr[min_index]) {
                    min_index = i;
                }
            }
            swap(arr,start,min_index);
            selectionSort(arr , start+1);
        }
    }

    private static void swap (int [] arr , int index1 , int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;

    }

    private static void printArray(int[] arr) {
        for ( int data : arr) {
            System.out.println(data);
        }
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int[] array = new int [scanner.nextInt()];

        for ( int i = 0 ; i < array.length; i ++) {
            array[i] = scanner.nextInt();
        }
        printArray(array);
        selectionSort(array);
        printArray(array);
    }
}
