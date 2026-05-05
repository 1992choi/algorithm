package programmers.codingtest;

import java.util.Stack;

// https://school.programmers.co.kr/learn/courses/30/lessons/76502
public class Ex010 {

    public static void main(String[] args) {
        System.out.println(solution("[](){}"));
        System.out.println(solution("}]()[{"));
        System.out.println(solution("[)(]"));
        System.out.println(solution("}}}"));
    }

    public static int solution(String s) {
        int result = 0;
        int pushOrPopCount = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();

            for (char c : s.toCharArray()) {
                if (c == '(' || c == '{' || c == '[') {
                    stack.push(c);
                    pushOrPopCount++;
                } else {
                    if (!stack.isEmpty()) {
                        char peekChar = stack.peek();
                        if (c == ')' && peekChar == '(') {
                            stack.pop();
                        }
                        if (c == '}' && peekChar == '{') {
                            stack.pop();
                        }
                        if (c == ']' && peekChar == '[') {
                            stack.pop();
                        }
                    }

                    pushOrPopCount--;
                }
            }

            if (pushOrPopCount == 0 && stack.isEmpty()) {
                result++;
            }

            s = s.substring(1) + s.charAt(0);
        }

        return result;
    }

}