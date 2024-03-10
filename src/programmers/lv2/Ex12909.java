package programmers.lv2;

import java.util.Stack;

// 프로그래머스 Lv2. 올바른 괄호 - https://school.programmers.co.kr/learn/courses/30/lessons/12909
public class Ex12909 {

    public static void main(String[] args) {
        System.out.println(solution("()()")); // true
        System.out.println(solution("(())()")); // true
        System.out.println(solution(")()(")); // false
        System.out.println(solution("(()(")); // false
    }

    public static boolean solution(String s) {
        Stack<Character> stack = new Stack<>();
        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                if (stack.isEmpty()) {
                    return false;
                }
                stack.pop();
            }
        }

        return stack.isEmpty();
    }

}
