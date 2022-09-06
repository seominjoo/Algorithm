package hello.helloSpring.programmers;

import java.util.Arrays;
import java.util.Comparator;

public class 스킬체크테스트Level1 {
    public static String[] solution(String[] strings, int n) {
        String[] answer = strings;
        Arrays.sort(answer);
        Arrays.sort(answer, Comparator.comparing(str -> str.charAt(n)));
        return answer;
    }

    public static void main(String[] args) {
        solution(new String[]{"sun", "bed", "car"}, 1);
        solution(new String[]{"abce", "abcd", "cdx"}, 2);
    }
}
