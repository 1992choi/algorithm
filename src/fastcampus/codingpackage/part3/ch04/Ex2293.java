package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 목표 금액 k를 만들 수 있는 경우의 수를 구하는 DP 문제
    - 동전의 순서는 고려하지 않고, 조합의 개수만 센다.

    - dp[x] 의미
        * 금액 x를 만들 수 있는 경우의 수

    - 핵심 아이디어
        * dp[0] = 1
          → 아무 동전도 사용하지 않고 0원을 만드는 경우는 1가지
        * 각 동전을 하나씩 순회하며 dp를 갱신
          → 같은 동전을 여러 번 쓰는 경우는 허용
          → 동전 순서를 고정함으로써 중복 조합을 제거

    - 점화 방식
        * coin[i]를 사용한다고 가정했을 때
          dp[j + coin[i]] += dp[j]
        * 즉, j원을 만드는 모든 방법 뒤에 coin[i]를 붙여
          (j + coin[i])원을 만드는 새로운 경우를 추가

    - 반복 순서가 중요한 이유
        * 동전 → 금액 순으로 순회해야
          (1+2)와 (2+1)을 같은 경우로 세지 않음
*/
class Ex2293 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();

        int[] coin = new int[n];
        int[] dp = new int[k + 1];

        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
        }

        dp[0] = 1;

        for (int i = 0; i < n; i++) {
            for (int j = 0; j + coin[i] <= k; j++) {
                dp[j + coin[i]] += dp[j];
            }
        }

        System.out.println(dp[k]);
    }

}
