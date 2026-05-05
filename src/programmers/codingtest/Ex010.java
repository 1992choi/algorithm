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

/*
public static int solution(String s) {
    // ❶ 괄호 정보를 저장함. 코드를 간결하게 할 수 있음
    HashMap<Character, Character> map = new HashMap<>();
    map.put(')', '(');
    map.put('}', '{');
    map.put(']', '[');

    int n = s.length(); // 원본 문자열의 길이 저장
    s += s; // 원본 문자열 뒤에 원본 문자열을 이어 붙여서 2번 나오도록 만들어줌

    int answer = 0;

    // ❷ 확인할 문자열의 시작 인덱스를 0 부터 n 까지 이동
    A:for (int i = 0; i < n; i++) {
        ArrayDeque<Character> stack = new ArrayDeque<>();

        // ❸ i(시작 위치)부터 원본 문자열의 길이인 n개까지 올바른 괄호 문자열인지 확인
        for (int j = i; j < i + n; j++) {
            char c = s.charAt(j);
            // HashMap 안에 해당 key 가 없다면 열리는 괄호임
            if (!map.containsKey(c)) {
                stack.push(c);
            }
            else {
                // ❹ 짝이 맞지 않으면 내부 for문은 종료하고 for문 A로 이동
                if(stack.isEmpty() || !stack.pop().equals(map.get(c)))
                    continue A;
            }
        }

        // ❺ 3에서 continue 되지 않았고, 스택이 비어있으면 올바른 괄호 문자열임
        if (stack.isEmpty())
            answer++;
    }

    return answer;
}
 */