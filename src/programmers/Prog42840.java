package programmers;

import java.util.ArrayList;
import java.util.List;

public class Prog42840 {
    public static void main(String[] args) {
        int[] answers = {1, 2, 3, 4, 5};
        solution(answers);
    }

    static int[] solution(int[] answers) {
        int[] a = {1, 2, 3, 4, 5};
        int[] b = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] c = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

        int[] scores = new int[3];
        for (int i = 0; i < answers.length; i++) {
            if(answers[i] == a[i % a.length]) scores[0]++;
            if(answers[i] == b[i % b.length]) scores[1]++;
            if(answers[i] == c[i % c.length]) scores[2]++;
        }

        int max = Math.max(scores[0], Math.max(scores[1], scores[2]));

        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < scores.length; i++) {
            if (max == scores[i]) {
                list.add(i + 1);
            }
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < answer.length; i++) {
            answer[i] = list.get(i);
        }

        return answer;
    }


}
