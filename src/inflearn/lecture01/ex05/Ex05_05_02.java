package inflearn.lecture01.ex05;

import java.util.Scanner;
import java.util.Stack;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex05_05_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static int solution(String s) {
        int answer = 0;

        Stack<Character> stack = new Stack<>();
        stack.push('('); // 첫 시작은 (로 시작될 수 밖에 없음
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push(s.charAt(i));
            } else {
                if (s.charAt(i - 1) == '(') { // 바로 앞의 문자가 '('이면 레이저인 경우
                    stack.pop();
                    answer += stack.size();
                } else { // 바로 앞의 문자가 '('이 아니면 막대기의 끝인 경우
                    stack.pop();
                    answer += 1;
                }
            }
        }

        return answer;
    }

}
