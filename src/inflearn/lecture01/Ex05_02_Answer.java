package inflearn.lecture01;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_02_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();
        for (char x : s.toCharArray()) {
            if (x == ')') {
                while (stack.pop() != '(');
            } else {
                stack.push(x);
            }
        }

        for (int i = 0; i < stack.size(); i++) {
            answer += stack.get(i);
        }

        return answer;
    }

}