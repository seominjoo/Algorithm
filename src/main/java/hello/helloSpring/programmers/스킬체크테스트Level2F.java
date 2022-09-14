package hello.helloSpring.programmers;

import java.util.ArrayList;
import java.util.List;

public class 스킬체크테스트Level2F {
    /*
문제 설명
그렙시에는 0으로 된 도로에 숫자 블록을 설치하기로 하였습니다. 숫자 블록의 규칙은 다음과 같습니다.

블록의 번호가 n 일 때, 가장 처음 블록은 n * 2번째 위치에 설치합니다. 그다음은 n * 3, 그다음은 n * 4, ...로 진행합니다.만약 기존에 블록이 깔려있는 자리라면 그 블록을빼고 새로운 블록으로 집어넣습니다.

예를 들어 1번 블록은 2,3,4,5, ... 인 위치에 우선 설치합니다. 그다음 2번 블록은 4,6,8,10, ... 인 위치에 설치하고, 3번 블록은 6,9,12... 인 위치에 설치합니다.

이렇게 3번 블록까지 설치하고 나면 첫 10개의 블록은 0, 1, 1, 2, 1, 3, 1, 2, 3, 2이됩니다.

그렙시는 길이가 1,000,000,000인 도로에 1번 블록부터 시작하여 10,000,000번 블록까지 위의 규칙으로 모두 놓았습니다.

그렙시의 시장님은 특정 구간의 어떤 블록이 깔려 있는지 알고 싶습니다.

구간을 나타내는 두 수 begin, end 가 매개변수로 주어 질 때, 그 구간에 깔려 있는 블록의 숫자 배열(리스트)을 return하는 solution 함수를 완성해 주세요.

제한 사항
begin, end 는 1 이상 1,000,000,000이하의 자연수 이고, begin는 항상 end보다 작습니다.
end - begin 의 값은 항상 10,000을 넘지 않습니다.
입출력 예
begin	end	result
1	10	[0, 1, 1, 2, 1, 3, 1, 4, 3, 5]
입출력 예 설명
입출력 예 #1
다음과 같이 블럭이 깔리게 됩니다.
Imgur

※ 공지 - 2019년 4월 07일 테스트케이스가 변경되었습니다.
*/
    public static int[] solution(long begin, long end) {
        int[] answer;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < end; i++) {
            if (i == 0 && begin == 1) {
                list.add(0);
            } else {
                list.add(null);
            }
        }

        int be = Math.toIntExact(begin);

        for (int j = 1; j <= end / 2; j++) {
            for (int k = 2; k <= end; k++) {
                for (int f = be; f <= end; f++) {
                    if ((j * k) % f == 0) {
                        System.out.println("j : " + j);
                        System.out.println("k : " + k);
                        System.out.println("j * k : " + j * k);
                        list.remove(j * k - 1);
                        list.add(j * k - 1, j);
                    }
                }
            }
        }

        System.out.println(list);
        answer = list.stream()
                .mapToInt(Integer::intValue)
                .toArray();
        return answer;
    }

    public static void main(String[] args) {

        System.out.println(solution(4, 12));
    }
}