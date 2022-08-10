package book.doitjava.chap06;

import java.util.Scanner;

public class BubbleSort {
    static void swap(int[] arr, int idx1, int idx2) {
        int temp = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = temp;
    }

    // 버블 정렬
    static void bubbleSort(int[] arr , int n) {
        for (int i = 0; i < n - 1; i++) {
            for (int j = n - 1; j > i; j--) {
                if ( arr[j-1] > arr[j]) {
                    swap(arr,j-1,j);
                }
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("버블 정렬(버전1)");
        System.out.println("요솟수: ");
        int[] arr = new int[scanner.nextInt()];

        for (int i = 0; i < arr.length; i++) {
            System.out.println("arr[" + i + "]: ");
            arr[i] = scanner.nextInt();
        }

        bubbleSort(arr , arr.length);

        System.out.println("오름차순으로 정렬했습니다.");
        for (int i = 0; i< arr.length; i++) {
            System.out.println("arr[" + i + "]=" + arr[i]);
        }
    }
}
