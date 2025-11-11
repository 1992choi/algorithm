package fastcampus.codingpackage.part2.ch02;

import java.util.Scanner;

/*
    풀이
    - 괄호의 중첩 구조를 분배법칙(곱셈 누적)으로 단순화하여 계산한다.

    1. 괄호 문자열의 값을 계산하기 위해 스택과 곱셈 누적 변수를 사용한다.
    2. 여는 괄호 '(' 또는 '['를 만나면, 현재 괄호 깊이에 따라 곱셈값(currentMultiple)을 누적한다.
       - '('이면 ×2, '['이면 ×3
    3. 닫는 괄호 ')' 또는 ']'를 만나면
       - 스택에서 짝이 맞는 여는 괄호인지 확인한다.
       - 직전 문자가 여는 괄호였다면 현재까지의 곱셈값을 결과(ans)에 더한다.
       - 괄호가 닫히므로 곱셈값을 원래대로 나눈다.
    4. 모든 괄호가 올바르게 닫혔는지(topIndex < 0) 확인해 최종 결과를 출력한다.
    5. 핵심은 'currentMultiple'을 통해 분배법칙처럼 괄호 깊이에 따른 곱셈을 유지하고, 닫히는 순간에만 필요한 값을 더하는 구조이다.
*/
public class Ex2504 {

    // 괄호 종류에 따라 계산에 사용할 값을 반환
    // () → 2, [] → 3
    static int delimiterToValue(char delimiter) {
        if (delimiter == '(' || delimiter == ')') return 2;
        else if (delimiter == '[' || delimiter == ']') return 3;
        return -1;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] input = sc.next().toCharArray();

        int[] stack = new int[input.length];  // 여는 괄호의 값을 저장
        int topIndex = -1;                    // 스택의 top 위치
        int currentMultiple = 1;              // 현재 괄호 깊이에 따른 곱셈값
        int ans = 0;                          // 계산 결과

        for (int i = 0; i < input.length; i++) {
            int delimiterValue = delimiterToValue(input[i]);

            // 1. 여는 괄호 '(' 또는 '['인 경우
            if (input[i] == '(' || input[i] == '[') {
                stack[++topIndex] = delimiterValue;   // 괄호 값을 스택에 저장
                currentMultiple *= delimiterValue;    // 중첩이 깊어질수록 배수 증가
            }

            // 2. 닫는 괄호 ')' 또는 ']'인 경우
            else {
                // 스택이 비었거나, 짝이 맞지 않으면 잘못된 입력
                if (topIndex < 0 || stack[topIndex--] != delimiterValue) {
                    ans = 0;
                    break;
                }

                // 3. 직전 문자가 여는 괄호이면 "()" 또는 "[]" 구조이므로 현재 값을 더함
                if (input[i - 1] == '(' || input[i - 1] == '[')
                    ans += currentMultiple;

                // 4. 닫힌 괄호이므로 깊이를 한 단계 줄임
                currentMultiple /= delimiterValue;
            }
        }

        // 5. 모든 괄호가 정상적으로 닫혔는지 확인
        System.out.println(topIndex < 0 ? ans : 0);
    }

}