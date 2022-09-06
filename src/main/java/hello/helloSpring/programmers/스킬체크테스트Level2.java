package hello.helloSpring.programmers;

import java.util.Arrays;

public class 스킬체크테스트Level2 {
    public static int solution(int n, int[] lost, int[] reserve) {
        int answer = 0;
        // 빌려주기 전 수업을 들을 수 있는 사람
        answer = n - lost.length;
        long count = 0;

        for (int lo : lost) {
            count = Arrays.stream(reserve).filter(re -> {
                if (re < lo) {
                    return re == lo - 1 || re == lo + 1;
                } else {
                    return lo == re - 1 || lo == re + 1;
                }
            }).count();
        }
        answer += count;
        System.out.println(answer);
        return answer;
    }

    public static void main(String[] args) {
        solution(5, new int[]{2, 4}, new int[]{1, 3, 5});  // 5
        solution(5, new int[]{2, 4}, new int[]{3}); // 4
        solution(3, new int[]{3}, new int[]{1}); // 2
    }
}
