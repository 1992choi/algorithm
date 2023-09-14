package inflearn.lecture01.ex05;

import java.util.Scanner;
import java.util.Stack;

public class Ex05_02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        String s = in.next();

        System.out.println(solution(s));
    }

    public static String solution(String s) {
        String answer = "";
        Stack<Character> stack = new Stack<>();

        for (Character c : s.toCharArray()) {
            if (c != ')') {
                stack.push(c);
            } else {
                while (stack.pop() != '(') ;
            }
        }

        for (Character character : stack) {
            answer += character;
        }

        return answer;
    }

}