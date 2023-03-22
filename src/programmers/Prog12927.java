package programmers;

import java.util.Arrays;

public class Prog12927 {
    public static void main(String[] args) {
        int[] ex = {2, 1, 2};
        int n = 1;

        System.out.println(solution(n,ex));
    }

    static long solution(int n, int[] works) {
        int sum = 0;
        for(int work : works) {
            sum += work;
        }

        if(n > sum) {
            return 0;
        }


        while (n > 0) {
            int max = 0;
            for (int i = 0; i < works.length; i++) {
                max = Math.max(works[i], max);
            }

            for (int i = 0; i < works.length; i++) {
                if (n <= 0) {
                    break;
                }
                if (works[i] == max) {
                    works[i] -= 1;
                    n--;
                }
            }
        }

        long answer = 0;
        for (int work : works) {
            answer += work * work;
        }

        return answer;
    }
}
