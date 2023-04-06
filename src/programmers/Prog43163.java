package programmers;

public class Prog43163 {
    public static void main(String[] args) {

        String begin = "hit";
        String target = "cog";
        String[] words = {"hot", "dot", "dog", "lot", "log"};

        System.out.println(solution(begin,target,words));
    }

    static int solution(String begin, String target, String[] words) {
        boolean hasTarget = false;
        for (String str : words) {
            if (str.equals(target)) {
                hasTarget = true;
                break;
            }
        }
        if (!hasTarget) {
            return 0;
        }
        int changeCnt = 0;
        for (int i = 0; i < words.length; i++) {

            char[] targetChars = target.toCharArray();
            char[] beginChars = begin.toCharArray();

            int equalCharCnt = 0;
            for (int k = 0; k < beginChars.length; k++) {
                if (beginChars[k] == targetChars[k]) {
                    equalCharCnt++;
                }
            }

            if (equalCharCnt == target.length()-1) {
                break;
            }

            char[] wordChars = words[i].toCharArray();

            equalCharCnt = 0;
            for (int j = 0; j < beginChars.length; j++) {
                if (beginChars[j] == wordChars[j]) {
                    equalCharCnt++;
                }
            }

            if (equalCharCnt >= 1) {
                begin = words[i];
                changeCnt++;
            }
        }

        return changeCnt+1;
    }
}
