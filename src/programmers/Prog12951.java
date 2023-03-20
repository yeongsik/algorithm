package programmers;

public class Prog12951 {
    public static void main(String[] args) {
        solution("3people unFollowed me");
        solution("for the last week");
    }


    static String solution(String s) {
        char[] chars = s.toCharArray();

        boolean isFirstChar = true;
        for (int i = 0; i < chars.length; i++) {
            if (isFirstChar) {
                if (chars[i] >= 97 && chars[i] <= 122) {
                    chars[i] = (char) (chars[i] - 32);
                }
                isFirstChar = false;
            } else {
                if (chars[i] >= 65 && chars[i] <= 90) {
                    chars[i] = (char) (chars[i] + 32);
                }
            }
            if (chars[i] == ' ') {
                isFirstChar = true;
            }
        }
        return String.valueOf(chars);



        // 65 ~ 90 대문자
        // 97 ~ 122 소문자
    }
}
