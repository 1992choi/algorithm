package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 목표 금액 t를 만들기 위해, 종류가 k개인 동전을 사용하는 경우의 수를 구하는 문제
    - 각 동전은 금액과 사용할 수 있는 개수가 제한되어 있음

    - dp[i][v] 의미
        * i번째 동전까지 고려했을 때, 금액 v를 만드는 경우의 수

    - 핵심 아이디어
        * 동전을 순서대로 하나씩 고려하며 DP를 진행
        * i번째 동전을 몇 개 사용할지(0 ~ coinCount)를 모두 시도
        * 이전 상태(dp[i-1])에서 현재 동전을 붙이는 방식

    - 점화 방식
        * dp[i][value + coinPrice * cnt] += dp[i-1][value]
        * 이전 동전들로 value를 만든 모든 경우에 대해
          현재 동전을 cnt개 붙여 새로운 금액을 만든다

    - 초기값
        * dp[0][0] = 1
          → 동전을 하나도 사용하지 않고 0원을 만드는 경우는 1가지

    - 동전 종류를 바깥 루프로 두기 때문에
      동전 순서에 따른 중복은 자연스럽게 제거된다
*/
class Ex2624 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        int k = sc.nextInt();
        int dp[][] = new int[k + 1][t + 1];

        dp[0][0] = 1;
        for (int i = 1; i <= k; i++) {
            int coinPrice = sc.nextInt();
            int coinCount = sc.nextInt();
            for (int value = 0; value <= t; value++) {
                for (int cnt = 0; cnt <= coinCount; cnt++) {
                    int nextValue = value + coinPrice * cnt;
                    if (nextValue > t) break;
                    dp[i][nextValue] += dp[i - 1][value];
                }
            }
        }
        System.out.println(dp[k][t]);
    }

}
