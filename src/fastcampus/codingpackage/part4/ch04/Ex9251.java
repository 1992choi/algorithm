package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 두 문자열의 공통 부분 수열 중 가장 긴 길이를 구하기 위해 DP를 사용
    - 각 문자열의 앞에서부터 차례대로 비교하면서 최적의 결과를 누적

  - DP 정의
    - dp[i][j] : 첫 번째 문자열의 i번째 문자까지와 두 번째 문자열의 j번째 문자까지를 사용했을 때의 LCS 길이

  - 초기 설정
    - 문자열 인덱스를 1부터 사용하기 위해 앞에 공백 문자를 하나 추가
    - dp 배열의 0행과 0열은 비교 대상이 없으므로 0으로 유지

  - 점화식
    - s1[i] == s2[j] 인 경우, dp[i][j] = dp[i - 1][j - 1] + 1
    - s1[i] != s2[j] 인 경우, dp[i][j] = max(dp[i - 1][j], dp[i][j - 1])
    - 현재 문자를 LCS에 포함할 수 있는지 여부에 따라 이전 상태 중 최적값을 선택

  - 전체 정답
    - dp[s1.length - 1][s2.length - 1] 값이 두 문자열의 LCS 길이

  - 시간 복잡도
    - O(N × M)
    - N, M은 각각 두 문자열의 길이
*/
class Ex9251 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // 문자열 앞에 공백을 추가하여 인덱스를 1부터 사용
        char[] s1 = (" " + sc.next()).toCharArray();
        char[] s2 = (" " + sc.next()).toCharArray();

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
    }

}
