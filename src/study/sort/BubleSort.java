package study.sort;

/**
 *  오름차순 버블 정렬 구현
 */
public class BubleSort {

    public static void main(String[] args) {
        int[] intArray = {5,7,3,2,4};

        for ( int i =0; i < intArray.length; i++) {
            for ( int n = 0; n<intArray.length-(1+i); n++) {
                if(intArray[n] > intArray[n+1]) {
                    int temp = intArray[n];
                    intArray[n] = intArray[n+1];
                    intArray[n+1] = temp;
                }
            }
        }

        for ( int i = 0; i < intArray.length; i++) {
            System.out.println(intArray[i]);
        }
    }
}
