package hello.helloSpring.programmers;

import java.util.LinkedList;
import java.util.Queue;

class 스택Lv2 {

/*   프린터
문제 설명
일반적인 프린터는 인쇄 요청이 들어온 순서대로 인쇄합니다. 그렇기 때문에 중요한 문서가 나중에 인쇄될 수 있습니다. 이런 문제를 보완하기 위해 중요도가 높은 문서를 먼저 인쇄하는 프린터를 개발했습니다.
이 새롭게 개발한 프린터는 아래와 같은 방식으로 인쇄 작업을 수행합니다.

1. 인쇄 대기목록의 가장 앞에 있는 문서(J)를 대기목록에서 꺼냅니다.
2. 나머지 인쇄 대기목록에서 J보다 중요도가 높은 문서가 한 개라도 존재하면 J를 대기목록의 가장 마지막에 넣습니다.
3. 그렇지 않으면 J를 인쇄합니다.
예를 들어, 4개의 문서(A, B, C, D)가 순서대로 인쇄 대기목록에 있고 중요도가 2 1 3 2 라면 C D A B 순으로 인쇄하게 됩니다.

내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 알고 싶습니다. 위의 예에서 C는 1번째로, A는 3번째로 인쇄됩니다.

현재 대기목록에 있는 문서의 중요도가 순서대로 담긴 배열 priorities와 내가 인쇄를 요청한 문서가 현재 대기목록의 어떤 위치에 있는지를 알려주는 location이 매개변수로 주어질 때,
내가 인쇄를 요청한 문서가 몇 번째로 인쇄되는지 return 하도록 solution 함수를 작성해주세요.

제한사항
현재 대기목록에는 1개 이상 100개 이하의 문서가 있습니다.
인쇄 작업의 중요도는 1~9로 표현하며 숫자가 클수록 중요하다는 뜻입니다.
location은 0 이상 (현재 대기목록에 있는 작업 수 - 1) 이하의 값을 가지며 대기목록의 가장 앞에 있으면 0, 두 번째에 있으면 1로 표현합니다.
입출력 예
priorities          location    return
[2, 1, 3, 2]	        2 -1 -1 0        1
[1, 1, 9, 1, 1, 1]	    0        5

입출력 예 설명
예제 #1

문제에 나온 예와 같습니다.

예제 #2

6개의 문서(A, B, C, D, E, F)가 인쇄 대기목록에 있고 중요도가 1 1 9 1 1 1 이므로 C D E F A B 순으로 인쇄합니다.
*/

    public static int solution(int[] priorities, int location) {
        int answer = 0;

        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(priorities[i]);
        }

        end:
        while (!queue.isEmpty()) {
            for (int j = 9; j >= queue.peek(); j--) { // 여기를 priorties에서 가장 큰 순으로 해서 했으면 더 효율적이지 않았을까?
                while (queue.contains(j) == true) {
                    // 큰 값이 앞에 오도록 돌리기
                    while (j > queue.peek()) {
                        int poll = queue.poll();
                        // 뒤로 보내기
                        queue.offer(poll);
                        // 내가 원한 번호 움직이기
                        location = (location - 1 == -1 ? queue.size() - 1 : location - 1);
                    }
                    // 큰 값이 앞이라면 앞에 삭제 후 카운트
                    queue.poll();
                    answer++;
                    // 내가 원한 번호였는지 확인
                    if (location == 0) {
                        break end;
                    }
                    // 내가 원한 번호 움직이기
                    location = (location - 1 == -1 ? queue.size() - 1 : location - 1);
                }
            }
        }
        return answer;
    }

    public static void main(String[] args) {

//        int[] priorities1 = {2, 1, 3, 2};
//        int location1 = 2;
//        int[] priorities2 = {1, 1, 9, 1, 1, 1};
//        int location2 = 0;
//        System.out.println("#### return1 " + solution(priorities1, location1));
//        System.out.println("#### return2 " + solution(priorities2, location2));

        try (java.util.Scanner s = new java.util.Scanner(new java.net.URL("https://api.ipify.org").openStream(), "UTF-8").useDelimiter("\\A")) {
            System.out.println("My current IP address is " + s.next());
        } catch (java.io.IOException e) {
            e.printStackTrace();
        }
    }
}