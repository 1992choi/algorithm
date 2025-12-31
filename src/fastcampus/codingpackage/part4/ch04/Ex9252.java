package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 두 문자열의 LCS(Longest Common Subsequence)를 DP로 계산
    - dp[i][j]는 s1의 i번째 문자까지와 s2의 j번째 문자까지 고려했을 때의 LCS 길이
    - dp 테이블을 채운 뒤 역추적을 통해 실제 LCS 문자열을 복원

  - DP 정의
    - dp[i][j] : s1의 앞 i개 문자와 s2의 앞 j개 문자로 만들 수 있는 LCS의 길이

  - 초기값
    - i == 0 또는 j == 0 인 경우 공집합이므로 dp[i][j] = 0

  - 점화식
    - s1[i] == s2[j] 인 경우 dp[i][j] = dp[i - 1][j - 1] + 1
    - s1[i] != s2[j] 인 경우 dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])

  - LCS 문자열 복원
    - dp[n][m]에서 시작하여 dp 값이 만들어진 경로를 거꾸로 추적
    - 문자가 같은 경우 해당 문자를 결과에 추가하고 대각선으로 이동
    - 문자가 다른 경우 dp 값이 유지된 방향으로 이동

  - 시간 복잡도
    - DP 계산 O(N × M)
    - 역추적 O(N + M)
*/
class Ex9252 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        char[] s1 = (' ' + sc.next()).toCharArray();
        char[] s2 = (' ' + sc.next()).toCharArray();

        int[][] dp = new int[s1.length][s2.length];

        for (int i = 1; i < s1.length; i++) {
            for (int j = 1; j < s2.length; j++) {
                if (s1[i] == s2[j]) {
                    dp[i][j] = dp[i - 1][j - 1] + 1;
                } else {
                    dp[i][j] = Math.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }

        System.out.println(dp[s1.length - 1][s2.length - 1]);

        int r = s1.length - 1;
        int c = s2.length - 1;
        StringBuilder sb = new StringBuilder();

        while (r > 0 && c > 0) {
            if (s1[r] == s2[c]) {
                sb.append(s1[r]);
                r--;
                c--;
            } else if (dp[r][c] == dp[r - 1][c]) {
                r--;
            } else {
                c--;
            }
        }

        System.out.println(sb.reverse());
    }

}
