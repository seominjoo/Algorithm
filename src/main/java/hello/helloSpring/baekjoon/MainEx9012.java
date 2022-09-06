package hello.helloSpring.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class MainEx9012 {

    public static String checkVps(String isVPS) {
        // 내 코드
//        int count = 0;
//        for (int i = 0; i < isVPS.length(); i++) {
//            isVPS.charAt(i);
//            if (isVPS.charAt(i) == '(') {
//                count++;
//            } else {
//                count--;
//            }
//            if(count < 0){
//                return "NO";
//            }
//        }
//
//        if (count == 0) {
//            return "YES";
//        }
//
//        return "NO";

        // 좋아요 코드
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < isVPS.length(); i++) {
            char c = isVPS.charAt(i);

            if (c == '(') {
                stack.push(c);
            } else if (stack.empty()) {
                return "NO";
            } else {
                stack.pop();
            }
        }

        if (stack.empty()) {
            return "YES";
        }
        return "NO";
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        while (T-- > 0) {
            System.out.println(checkVps(scan.next()));
        }
    }
}
