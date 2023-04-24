package inflearn.lecture01;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else if (c == ')') {
                stack.pop();
            } else {
                if (stack.isEmpty()) {
                    answer += c;
                }
            }
        }

        return answer;
    }

}