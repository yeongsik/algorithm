package programmers;

public class Pro20221005_2 {

    public String solution(String s) {
        String answer = "";
        
        char[] chars = s.toCharArray();

        if (chars.length % 2 == 1) {
            answer += chars[chars.length/2];
        } else {
            answer += chars[chars.length / 2 -1];
            answer += chars[chars.length / 2 ];
        }
        return answer;
    }
}
