package hello.helloSpring.programmers;

public class 스킬체크테스트Level2D {
    /*
* 문제 설명
짝지어 제거하기는, 알파벳 소문자로 이루어진 문자열을 가지고 시작합니다. 먼저 문자열에서 같은 알파벳이 2개 붙어 있는 짝을 찾습니다. 그다음, 그 둘을 제거한 뒤, 앞뒤로 문자열을 이어 붙입니다. 이 과정을 반복해서 문자열을 모두 제거한다면 짝지어 제거하기가 종료됩니다. 문자열 S가 주어졌을 때, 짝지어 제거하기를 성공적으로 수행할 수 있는지 반환하는 함수를 완성해 주세요. 성공적으로 수행할 수 있으면 1을, 아닐 경우 0을 리턴해주면 됩니다.

예를 들어, 문자열 S = baabaa 라면

b aa baa → bb aa → aa →

의 순서로 문자열을 모두 제거할 수 있으므로 1을 반환합니다.

제한사항
문자열의 길이 : 1,000,000이하의 자연수
문자열은 모두 소문자로 이루어져 있습니다.
입출력 예
s	result
baabaa	1
cdcd	0
입출력 예 설명
입출력 예 #1
위의 예시와 같습니다.
입출력 예 #2
문자열이 남아있지만 짝지어 제거할 수 있는 문자열이 더 이상 존재하지 않기 때문에 0을 반환합니다.

※ 공지 - 2020년 6월 8일 테스트케이스가 추가되었습니다.
*/
    public static int solution(String s) {
        int size = s.length(), count = 0;

        System.out.println("# 들어온 값 " + s);

        for (int i = 0; i < s.length(); i++) {
            for (int j = 0; j < s.length(); j++) {
                count++;
                String s1 = String.valueOf(s.charAt(j));
                // 정규표현식
                String pattern_1 = "(" + s1 + "){2}";
                // 중복처리
                if (s.matches(".*" + pattern_1 + ".*")) {
                    System.out.println("# 나온 단어 " + s1);
                    s = s.replaceAll(pattern_1, "");
                    System.out.println("# 변경된 값 " + s);
                    j = -1;
                    count = 0;
                    if(s.isEmpty()){
                        return 1;
                    }
                } else {
                    System.out.println("# 나온 단어 " + s1);
                    // 중복없음
                    if (count == s.length()) {
                        return 0;
                    }
                }
            }

            // 중복이 없을 경우
            if (size == s.length()) {
                return 0;
            }
        }
        return 1;
    }

    public static void main(String[] args) {
        String s1 = "caadcacaacc#@@d@";
        String s2 = "cdcac#d@";
        String s3 = "baabaa";
//        String s = s1.replaceAll("(a-z).{2}", "");
//        System.out.println(s);


        String answer = "";

        for (int i = 0; i < s3.length(); i++) {
            if(s3.indexOf(s3.charAt(i)) == i) answer += s3.charAt(i);
        }

        System.out.println(answer);


//        System.out.println(s1.matches(".*" + (){2} + ".*"));
//        String s = "cdc#@@dd@".replaceAll("[a-z]", "");

//        System.out.println(solution("baabaa"));
//        System.out.println(solution("cdcd"));
//        System.out.println(solution("ccdcd"));
    }
}