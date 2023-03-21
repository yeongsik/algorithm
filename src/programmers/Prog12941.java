package programmers;

import java.util.Arrays;
import java.util.Collections;

public class Prog12941 {

    public static void main(String[] args) {
        int[] arr = {1, 4, 2};
        int[] arr2 = {5, 4, 4};
        System.out.println(solution(arr,arr2));
    }

    static int solution(int[] A, int[] B) {
        Arrays.sort(A);
        Arrays.sort(B);

        int sum = 0;
        for (int i = 0; i < A.length; i++) {
            sum += A[i] * B[B.length-1-i];
        }

        return sum;
    }
}
