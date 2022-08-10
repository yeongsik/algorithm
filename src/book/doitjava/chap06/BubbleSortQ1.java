package book.doitjava.chap06;

import java.util.Scanner;

public class BubbleSortQ1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int arr[] = new int[scanner.nextInt()];
        for (int i=0; i<arr.length; i++) {

            arr[i] = scanner.nextInt();
            System.out.println("arr[" + i + "] =" + arr[i]);
        }

        bubleSort(arr);

        for (int i=0; i<arr.length; i++){
            System.out.println("arr[" +i+"] = " + arr[i]);
        }
    }

    static void swap (int [] arr , int idx1 , int idx2) {
        int tempInt = arr[idx1];
        arr[idx1] = arr[idx2];
        arr[idx2] = tempInt;
    }

    static void bubleSort (int[] arr) {
        for (int i = 0; i < arr.length-1; i++) {
            System.out.println("패스 "+i+1+":");
            for (int j= 0; j < arr.length-(1+i); j++) {
                if(arr[j] > arr[j+1]) {
                    swap(arr, j , j+1);
                }
            }
            System.out.println();
        }
    }
}
