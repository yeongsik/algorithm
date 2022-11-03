package programmers;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/43165
    타겟넘버
 */
public class Pro20221103 {
    static int[] numbers;
    static int target;
    static int cnt;
    public static void main(String[] args) {
        int[] testArr = {1, 1, 1, 1, 1};
        int targetNum = 3;

        Pro20221103 test = new Pro20221103();
        System.out.println(test.solution(testArr,targetNum));
    }
    public int solution(int[] numbers, int target) {
        int answer = 0;
        this.numbers = numbers;
        this.target = target;

        DFS(0, numbers[0]);
        DFS(0, -numbers[0]);
        answer = cnt;
        return answer;
    }
    static void DFS(int idx, int sum) {
        if (idx == numbers.length - 1) {
            if (sum == target) {
                cnt++;
            }
            return;
        }
        DFS(idx + 1, sum+numbers[idx]);
        DFS(idx + 1, sum-numbers[idx]);
    }
}
