package programmers.etc;

import java.util.Stack;

// 코딩 테스트 합격자 되기 : 06-2
public class Ex09 {

    public static void main(String[] args) {
        System.out.println(solution(10)); // 1010
        System.out.println(solution(27)); // 11011
        System.out.println(solution(12345)); // 11000000111001
    }

    public static String solution(int decimal) {
        // 나머지 스택에 담기
        Stack<Integer> stack = new Stack<>();
        while (decimal != 0) {
            stack.push(decimal % 2);
            decimal /= 2;
        }

        // 스택 순회하면서 값 꺼내기
        StringBuilder sb = new StringBuilder();
        while (!stack.isEmpty()) {
            sb.append(stack.pop());
        }

        return sb.toString();
    }

}
