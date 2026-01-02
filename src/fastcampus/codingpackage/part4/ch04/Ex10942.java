package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 구간 [s, e]가 팰린드롬인지 여부를 DP로 판단
    - 양 끝 값이 같고, 그 안쪽 구간도 팰린드롬이면 전체 구간도 팰린드롬
    - 여러 질의가 있으므로 이미 계산한 결과는 메모이제이션으로 재사용

  - DP 정의
    - dp[s][e] : s번째부터 e번째까지의 수열이 팰린드롬이면 1, 아니면 0

  - 종료 조건
    - start >= end 인 경우 길이가 0 또는 1이므로 항상 팰린드롬
    - 이미 계산된 dp 값이 있다면 바로 반환

  - 점화식
    - arr[start] != arr[end] 이면 팰린드롬이 아니므로 0
    - arr[start] == arr[end] 이면 dp[start][end] = dp[start + 1][end - 1]

  - 전체 흐름
    - 각 질의마다 재귀적으로 팰린드롬 여부를 확인
    - 결과는 dp 배열에 저장하여 중복 계산 방지

  - 시간 복잡도
    - DP 상태 수는 O(N^2)
    - 각 상태는 한 번만 계산되므로 전체 시간 복잡도는 O(N^2)
*/
class Ex10942 {

    static int[][] dp = new int[2001][2001];
    static int[] arr = new int[2001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
            for (int j = 1; j <= n; j++) {
                dp[i][j] = -1;
            }
        }

        int m = sc.nextInt();
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < m; i++) {
            int s = sc.nextInt();
            int e = sc.nextInt();
            sb.append(isPalindrome(s, e)).append('\n');
        }
        System.out.println(sb);
    }

    static int isPalindrome(int start, int end) {
        if (start >= end) return 1;
        if (dp[start][end] != -1) return dp[start][end];

        if (arr[start] != arr[end]) {
            dp[start][end] = 0;
        } else {
            dp[start][end] = isPalindrome(start + 1, end - 1);
        }
        return dp[start][end];
    }

}
