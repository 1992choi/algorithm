package inflearn.lecture01;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s)); // 오답
    }

    public static int solution(String s) {
        int answer = 0;
        Stack<Character> stack = new Stack<>();

        for (char c : s.toCharArray()) {
            if (c == '(') {
                stack.push(c);
            } else {
                char tmp = stack.peek();
                if (tmp == '(') {
                    stack.pop();
                    answer += stack.size();
                } else {
                    stack.pop();
                    answer++;
                }

            }
        }

        return answer;
    }

}