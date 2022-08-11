package study.sort.quicksort;

/**
 * 엔지니어 대한민국 유튜브 : 퀵정렬 구현 코드
 * 기준값 ( 피벗 ) : 배열의 중간인덱스로 설정
 */
public class QuickSortExample1 {
    private static void quickSort(int[] arr) {
        quickSort(arr, 0, arr.length - 1);
    }

    private static void quickSort(int[] arr, int start, int end) {
        int part2 = partition(arr, start, end); // 파티션을 나누기
        if (start < part2 - 1) { // 반환된 중간 인덱스가 시작값보다 클경우 end로 잡고 재귀 진행
            quickSort(arr, start, part2 - 1);
        }
        if (part2 < end) { // 반환된 중간 인덱스가 끝값보다 작을 경우 start로 설정 후 재귀 진행
            quickSort(arr, part2, end);
        }
    }

    /**
     * 해당 배열의 파티션을 나누는 메서드
     * @param arr
     * @param start
     * @param end
     * @return 정렬이 끝난 후 기준값의 인덱스를 반환 ( 정렬 끝난 중간 인덱스 )
     */
    private static int partition(int[] arr, int start, int end) {
        int pivot = arr[(start + end) / 2]; // 피벗 (기준값) 해당 배열 중간 인덱스로 설정
        while (start <= end) { // 시작점이 끝점보다 작을때까지 반복
            while(arr[start] < pivot) start++; // 기준값보다 값이 작으면 패스 or 값이 크면 start부분 멈춘 상태
            while(arr[end] > pivot) end--; // 기준값보다 값이 크면 패스  or 값이 작으면 end부분 멈춘 상태
            if (start <= end) { // 내부 while문 두개가 반복이 끝난 상황에서 1차 while조건이 그대로 유지되고 있다면 스왑진행
                swap(arr, start, end); // arr[start]값과 arr[end]값 교환
                start++;
                end--;
            }
        }
        return start;
    }

    private static void swap(int[] arr, int start, int end) {
        int tmp = arr[start];
        arr[start] = arr[end];
        arr[end] = tmp;
    }

    private static void printArray(int[] arr) {
        for (int data : arr) {
            System.out.print(data + ", ");
        }
        System.out.println();
    }
    public static void main(String[] args) {
        int[] arr = {3, 9, 4, 7, 5, 0, 1, 6, 8, 2};
        printArray(arr);
        quickSort(arr);
        printArray(arr);
    }
}
