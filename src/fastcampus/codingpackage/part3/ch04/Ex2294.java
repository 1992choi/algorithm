package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 목표 금액 k를 만들기 위한 최소 동전 개수를 구하는 DP 문제
    - 그리디로는 해결할 수 없고, 모든 경우를 누적해서 비교해야 한다.

    - dp[x] 의미
        * 금액 x를 만들기 위한 최소 동전 개수
        * 만들 수 없는 경우는 큰 값(100001)으로 유지

    - 초기화
        * dp[0] = 0 (명시적으로 쓰진 않지만 기본값)
        * 나머지는 모두 불가능 상태로 초기화
        * 동전 하나로 만들 수 있는 금액은 dp[coin] = 1

    - 점화 개념
        * 어떤 금액 i가 만들어졌다면
          - i + coin[j] 도 dp[i] + 1 로 갱신 가능
          - i - coin[j] 에서 오는 경우도 고려 가능
        * 결국 모든 금액 조합을 순회하며 최소값을 갱신

    - 마지막 결과
        * dp[k]가 초기값 그대로면 만들 수 없음 → -1
        * 아니면 dp[k] 출력
*/
class Ex2294 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int coin[] = new int[n];
        int dp[] = new int[k + 1];

        // 만들 수 없는 상태를 큰 값으로 초기화
        for (int i = 1; i <= k; i++) {
            dp[i] = 100001;
        }

        // 동전 하나로 만들 수 있는 금액 초기화
        for (int i = 0; i < n; i++) {
            coin[i] = sc.nextInt();
            if (coin[i] <= k)
                dp[coin[i]] = 1;
        }

        for (int i = 1; i <= k; i++) {
            for (int j = 0; j < n; j++) {
                if (i + coin[j] <= k)
                    dp[i + coin[j]] = Math.min(dp[i + coin[j]], dp[i] + 1);
                if (i - coin[j] >= 0)
                    dp[i] = Math.min(dp[i], dp[i - coin[j]] + 1);
            }
        }

        if (dp[k] == 100001) {
            System.out.println(-1);
        } else {
            System.out.println(dp[k]);
        }
    }

}
