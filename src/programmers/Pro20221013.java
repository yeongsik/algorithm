package programmers;

/*
    https://school.programmers.co.kr/learn/courses/30/lessons/120956
    문제명 : 옹알이
 */
public class Pro20221013 {

    public static void main(String[] args) {

        String[] babbling = {"ayayeeumaamaauyee", "yee", "u", "maa"};
        System.out.println(solution(babbling));


    }
    public static int solution(String[] babbling) {

        int answer = 0;
        String[] possibleWords = {"aya", "ye", "woo", "ma"};

        for (int i = 0; i < babbling.length; i++) {
            for (int j = 0; j < possibleWords.length; j++) {
                babbling[i] = babbling[i].replaceFirst(possibleWords[j], "");
            }
            if (babbling[i].equals("")) {
                answer++;
            }
        }
        return answer;
    }
}
