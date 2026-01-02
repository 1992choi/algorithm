package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - dp[i][j]를 (i, j)를 오른쪽 아래 꼭짓점으로 하는 가장 큰 정사각형의 한 변의 길이로 정의
    - 현재 칸이 1일 때만 정사각형을 만들 수 있음
    - 왼쪽, 위, 왼쪽 위 세 방향의 최소값에 1을 더하면 현재 만들 수 있는 최대 정사각형 크기

  - DP 정의
    - dp[i][j] : (i, j)를 오른쪽 아래 꼭짓점으로 하는 최대 정사각형의 한 변 길이

  - 점화식
    - arr[i][j] == 1 인 경우
      dp[i][j] = min(dp[i - 1][j], dp[i][j - 1], dp[i - 1][j - 1]) + 1
    - arr[i][j] == 0 인 경우
      dp[i][j] = 0

  - 전체 정답
    - dp 배열에서 가장 큰 값의 제곱이 가장 큰 정사각형의 넓이

  - 시간 복잡도
    - O(N × M)
*/
class Ex1915 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int m = sc.nextInt();

        int[][] arr = new int[n + 1][m + 1];
        int[][] dp = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            String s = sc.next();
            for (int j = 1; j <= m; j++) {
                arr[i][j] = s.charAt(j - 1) - '0';
            }
        }

        int max = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= m; j++) {
                if (arr[i][j] == 1) {
                    dp[i][j] = Math.min(
                            dp[i - 1][j - 1],
                            Math.min(dp[i - 1][j], dp[i][j - 1])
                    ) + 1;
                    max = Math.max(max, dp[i][j]);
                }
            }
        }

        System.out.println(max * max);
    }

}
