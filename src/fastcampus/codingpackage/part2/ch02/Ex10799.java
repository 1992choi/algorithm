package fastcampus.codingpackage.part2.ch02;

import java.util.Scanner;

public class Ex10799 {

    public static void main(String[] args) {
        /*
            1. '('를 만나면 쇠막대기 시작으로 보고 openCount 증가.

            2. ')'를 만나면:
                직전 문자가 '(' → "()" 형태이면 레이저.
                → 지금까지 열려 있는 쇠막대기(openCount)를 모두 자르므로 ans += openCount.

                직전 문자가 ')' → 쇠막대기 하나가 끝남.
                → 잘린 조각 중 마지막 한 조각을 더해야 하므로 ans++.

            3. 마지막까지 순회 후 ans를 출력하면 전체 쇠막대기 조각 수 완성.
         */
        Scanner sc = new Scanner(System.in);

        // 입력 문자열을 문자 배열로 변환 (예: "()(((()())(())()))(())")
        char[] input = sc.next().toCharArray();

        int openCount = 0; // 현재 열려 있는 '('의 개수 (즉, 잘리지 않은 쇠막대기의 수)
        int ans = 0;       // 최종 잘린 쇠막대기 조각의 총 개수

        // 문자열을 왼쪽부터 한 문자씩 확인
        for (int i = 0; i < input.length; i++) {
            if (input[i] == '(') {
                // 여는 괄호면, 새로운 쇠막대기 시작 또는 레이저의 일부일 수 있음
                openCount++;
            } else {
                // 닫는 괄호인 경우
                openCount--; // 일단 직전의 '('와 쌍을 이루므로 하나 닫힘

                if (input[i - 1] == '(') {
                    // 직전이 '('이면 "()" → 레이저
                    // 레이저는 현재 열려 있는 쇠막대기들을 모두 자름
                    ans += openCount;
                } else {
                    // 직전이 ')'이면 쇠막대기의 끝
                    // 잘린 쇠막대기 조각 중 하나가 완전히 끝났으므로 +1
                    ans++;
                }
            }
        }

        // 최종 결과 출력
        System.out.println(ans);
    }

}