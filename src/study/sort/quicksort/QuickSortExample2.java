package study.sort.quicksort;

/**
 * 위키백과 퀵 정렬 예제 코드
 */
public class QuickSortExample2 {
    private static void quickSort(int[] arr, int left, int right) {
        int i,j,pivot,tmp; // 사용 변수들 초기화 -> 이게 맞나? , 변수명 불명확함 i 가 뭐고 j가 뭔지
        if (left < right) { // 매개변수로 들어오는 left 값이 right값 보다 작을 경우 left 해당 배열의 왼쪽 시작값 , right : 해당 배열의 오른쪽 끝 인덱스 값
            i = left; j = right;
            pivot = arr[(left + right) / 2]; // 피벗을 중간값 인덱스로 지정 -> 다른 방법이 있는지 살펴보기
            while (i < j) { // left < right 조건과 같은 이야기
                while(arr[j] > pivot) j--; // 배열의 오른쪽에 있는 데이터 값이 피벗보다 값이 크면 패스
                while(i < j && arr[i] < pivot) i++; // 배열의 왼쪽에 있는 데이터 값이 피벗보다 작으면 패스

                //두 내부 while문을 빠져나오는 경우 두개의 값 스왑 진행
                tmp = arr[i];
                arr[i] = arr[j];
                arr[j] = tmp;
            }
            // 정렬 과정
            quickSort(arr,left,i-1);
            quickSort(arr,i+1,right);
        }
    }
}
