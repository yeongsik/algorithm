package baekjoon.sortnumber;

import java.util.Random;
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

        quickSort(intArray);
        printIntArr(intArray);

    }

    private static void quickSort(int[] arr) {
        quickSort(arr , 0 , arr.length-1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int partNumber = partition(arr, start, end);

        if (start < partNumber-1) {
            quickSort(arr,start,partNumber-1);
        }
        if (partNumber < end) {
            quickSort(arr, partNumber, end);
        }
    }

    private static int partition(int[] arr, int start, int end) {
        Random random = new Random();
        int pivot = arr[random.nextInt(arr.length)];

        while (start <= end) {
            while ( arr[start] < pivot ) start++;
            while ( arr[end] > pivot ) end--;
            if (start <= end) {
                swap(arr, start, end);
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int index1, int index2) {
        int tmp = arr[index1];
        arr[index1] = arr[index2];
        arr[index2] = tmp;
    }

    private static void printIntArr(int[] arr) {
        for (int a : arr) {
            System.out.println(a);
        }
    }
}
