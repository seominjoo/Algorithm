package hello.helloSpring.baekjoon;

import java.util.Scanner;
import java.util.Stack;

public class Main {

    static Stack<Integer> stack = new Stack<>();

    public static void StackQueue(String stackValue) {
        if (stackValue.contains("push")) {
            Integer pushX = Integer.valueOf(stackValue.split(" ")[1]);
            stack.push(pushX);
        } else if (stackValue.equals("pop")) {
            System.out.println(stack.empty() ? -1 : stack.pop());
        } else if (stackValue.equals("size")) {
            System.out.println(stack.size());
        } else if (stackValue.equals("empty")) {
            System.out.println(stack.empty() ? 1 : 0);
        } else {
            System.out.println(stack.empty() ? -1 : stack.peek());
        }
    }

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        int T = scan.nextInt();
        scan.nextLine();
        while (T-- > 0) {
            StackQueue(scan.nextLine());
        }
    }
}
