package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 배낭 문제(0/1 Knapsack)
    - 무게 제한 k를 넘지 않으면서, 얻을 수 있는 가치의 최댓값을 구하는 문제
    - 각 물건은 한 번만 선택 가능 (0/1)

    - dp[j] 의미
        * 배낭의 허용 무게가 j일 때 얻을 수 있는 최대 가치

    - 핵심 아이디어
        * 물건을 하나씩 순회하면서 dp를 갱신
        * 현재 물건(w, v)을 선택하는 경우:
            dp[j] = dp[j - w] + v
        * 선택하지 않는 경우:
            dp[j] = 기존 dp[j]
        * 둘 중 큰 값을 선택

    - 중요한 포인트
        * j를 k → w 방향으로 역순 탐색
        * 같은 물건이 여러 번 사용되는 것을 방지하기 위함
          (정방향으로 돌면 이전에 갱신한 값이 다시 사용됨)

    - 최종 답
        * dp[k]에 무게 k 이하에서의 최대 가치가 저장됨
*/
class Ex12865 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        int k = sc.nextInt();
        int dp[] = new int[k + 1];
        for (int i = 0; i < n; i++) {
            int w = sc.nextInt();
            int v = sc.nextInt();
            for (int j = k; j >= w; j--) {
                dp[j] = Math.max(dp[j], dp[j - w] + v);
            }
        }
        System.out.println(dp[k]);
    }

}
