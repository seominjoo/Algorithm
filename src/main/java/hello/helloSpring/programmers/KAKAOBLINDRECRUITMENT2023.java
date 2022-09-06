package hello.helloSpring.programmers;

import java.util.Arrays;

public class KAKAOBLINDRECRUITMENT2023 {

    public static int[] solution(int[][] v) {

        int x = v[0][0], y = v[1][0];
        Arrays.stream(v).sorted();
        for (int i = 1; i < v.length - 1; i++) {
            if (x == v[i][0]) {

            }
            x = v[i][0];
            y = v[i][1];
        }
        int[] answer = {};

        System.out.println("Hello Java");

        return answer;
    }

    public static void main(String[] args) {

    }
}
