package programmers.lv2;

import java.util.Stack;

// 프로그래머스 Lv2. 괄호 회전하기 - https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Ex76502 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}")); // 3
        System.out.println(solution("}]()[{")); // 2
        System.out.println(solution("[)(]")); // 0
        System.out.println(solution("}}}")); // 0
    }

    public static int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length() - 1; i++) {
            Stack<Character> stack = new Stack<>();
            for (int j = 0; j < s.length(); j++) {
                if(!stack.isEmpty()) {
                    char currentPeek = stack.peek();
                    if (currentPeek == '(' && s.charAt(j) == ')') {
                        stack.pop();
                    } else if (currentPeek == '[' && s.charAt(j) == ']') {
                        stack.pop();
                    } else if (currentPeek == '{' && s.charAt(j) == '}') {
                        stack.pop();
                    } else {
                        stack.push(s.charAt(j));
                    }
                } else {
                    stack.push(s.charAt(j));
                }
            }

            if (stack.isEmpty()) {
                answer++;
            }

            // 문자열 회전
            s = s.substring(1, s.length()) + s.charAt(0);
        }

        return answer;
    }

}

