package inflearn;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_04 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<String> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '+') {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a + b));
            } else if (c == '-') {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b - a));
            } else if (c == '*') {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(a * b));
            } else if (c == '/') {
                int a = Integer.parseInt(stack.pop());
                int b = Integer.parseInt(stack.pop());
                stack.push(String.valueOf(b / a));
            } else {
                stack.push(String.valueOf(c));
            }
        }

        return Integer.valueOf(stack.pop());
    }

}