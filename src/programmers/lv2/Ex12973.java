package programmers.lv2;

import java.util.Stack;

// 프로그래머스 Lv2. 짝지어 제거하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12973
public class Ex12973 {

    public static void main(String[] args) {
        System.out.println(solution("baabaa")); // 1
        System.out.println(solution("cdcd")); // 0
    }

    public static int solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (stack.isEmpty()) {
                stack.push(ch);
            } else {
                if (stack.peek() == ch) {
                    stack.pop();
                } else {
                    stack.push(ch);
                }
            }
        }

        return stack.isEmpty() ? 1 : 0;
    }

}

