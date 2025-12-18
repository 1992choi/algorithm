package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - 길이가 n인 계단 수의 개수를 구하는 문제
    - 계단 수: 인접한 자리의 숫자 차이가 정확히 1인 수
    - 맨 앞자리는 0이 될 수 없음

    - dp[i][j] 의미
        * 길이가 i이고, 마지막 숫자가 j인 계단 수의 개수

    - 초기값
        * 길이 1일 때, 1~9는 각각 1개씩 가능
        * 0으로 시작하는 수는 허용되지 않으므로 dp[1][0] = 0

    - 점화식
        * 마지막 숫자가 0인 경우 → 이전 숫자는 반드시 1
            dp[i][0] = dp[i-1][1]
        * 마지막 숫자가 9인 경우 → 이전 숫자는 반드시 8
            dp[i][9] = dp[i-1][8]
        * 그 외(1~8)는 양쪽에서 올 수 있음
            dp[i][j] = dp[i-1][j-1] + dp[i-1][j+1]

    - 모든 계산은 MOD로 나머지 처리
    - 최종 답은 길이 n에서 마지막 숫자가 0~9인 경우의 합
*/
class Ex10844 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int MOD = 1000000000;
        int n = sc.nextInt();
        int[][] d = new int[n + 1][10];
        for (int i = 1; i <= 9; i++) {
            d[1][i] = 1;
        }
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j <= 9; j++) {
                switch (j) {
                    case 0 -> d[i][j] = d[i - 1][j + 1] % MOD;
                    case 9 -> d[i][j] = d[i - 1][j - 1] % MOD;
                    default -> d[i][j] = (d[i - 1][j - 1] + d[i - 1][j + 1]) % MOD;
                }
            }
        }
        int sum = 0;
        for (int i = 0; i <= 9; i++) {
            sum = (sum + d[n][i]) % MOD;
        }
        System.out.println(sum);
    }

}
