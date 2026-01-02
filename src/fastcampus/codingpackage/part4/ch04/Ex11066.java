package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 연속된 파일들을 합칠 때 항상 두 구간을 나누는 분할 DP 문제
    - i번 파일부터 j번 파일까지 하나로 합치는 최소 비용을 DP로 관리
    - 마지막에 두 덩어리를 합칠 때는 해당 구간의 전체 파일 크기 합이 추가로 필요

  - DP 정의
    d[i][j] : i번 파일부터 j번 파일까지 하나로 합치는 최소 비용

  - 초기값
    - 파일 하나만 있는 경우는 합칠 필요가 없으므로 d[i][i] = 0

  - 점화식
    - i ≤ p < j 인 모든 p에 대해
      d[i][j] = min(d[i][p] + d[p+1][j] + (i~j 파일 크기의 합))

  - 계산 순서
    - 구간 길이를 1부터 점점 늘려가며 작은 구간부터 DP를 채움

  - 전체 정답
    - d[1][k] 가 전체 파일을 하나로 합치는 최소 비용

  - 시간 복잡도
    - O(K^3)
*/
class Ex11066 {

    static final int INF = 1000000000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        for (int tc = 1; tc <= t; tc++) {
            int k = sc.nextInt();

            int[] file = new int[k + 1];
            int[] sum = new int[k + 1];

            for (int i = 1; i <= k; i++) {
                file[i] = sc.nextInt();
                sum[i] = sum[i - 1] + file[i];
            }

            int[][] d = new int[k + 1][k + 1];

            for (int i = 1; i <= k; i++) {
                for (int j = 1; j <= k; j++) {
                    d[i][j] = INF;
                }
                d[i][i] = 0;
            }

            for (int length = 1; length <= k - 1; length++) {
                for (int i = 1; i + length <= k; i++) {
                    int end = i + length;
                    for (int p = i; p < end; p++) {
                        d[i][end] = Math.min(
                                d[i][end],
                                d[i][p] + d[p + 1][end] + rangeSum(sum, i, end)
                        );
                    }
                }
            }

            System.out.println(d[1][k]);
        }
    }

    static int rangeSum(int[] sum, int i, int j) {
        return sum[j] - sum[i - 1];
    }

}
