package inflearn.lecture01.ex05;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "YES";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return "NO";
                }

                stack.pop();
            }
        }

        if (!stack.isEmpty()) {
            return "NO";
        }

        return answer;
    }

}