package inflearn.lecture01;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_01 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                try {
                    stack.pop();
                } catch (Exception e) {
                    return "NO";
                }
            }
        }

        if (stack.size() == 0) {
            return "YES";
        } else {
            return "NO";
        }
    }

}