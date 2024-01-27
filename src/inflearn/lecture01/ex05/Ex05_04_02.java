package inflearn.lecture01.ex05;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (Character.isDigit(ch)) {
                stack.push(ch);
            } else {
                int a = stack.pop() - 48;
                int b = stack.pop() - 48;
                int result = 0;
                if (ch == '+') {
                    result = b + a;
                } else if (ch == '-') {
                    result = b - a;
                } else if (ch == '*') {
                    result = b * a;
                } else {
                    result = b / a;
                }

                stack.push((char) (result + 48));
            }

        }

        return stack.pop() - 48;
    }

}