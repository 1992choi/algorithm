package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - N개의 집이 일렬로 있고, 각 집을 R/G/B 중 하나로 칠해야 한다.
    - 인접한 집은 같은 색을 사용할 수 없다.
    - 모든 집을 칠하는 최소 비용을 구하는 문제

    - DP 정의
        d[i][색] : i번째 집까지 칠했을 때,
                   i번째 집을 해당 색으로 칠한 경우의 최소 비용

        색 인덱스
            R = 1
            G = 2
            B = 3

    - 왜 DP인가?
        * i번째 집의 색 선택은
          i-1번째 집의 색 선택 결과에만 영향을 받는다.
        * 이전 상태의 최솟값을 이용해 현재 상태를 계산할 수 있다.

    - 점화식 도출

        1) i번째 집을 빨강(R)으로 칠하는 경우
           → i-1번째 집은 G 또는 B만 가능
           d[i][R] = min(d[i-1][G], d[i-1][B]) + 빨강 비용

        2) i번째 집을 초록(G)으로 칠하는 경우
           → i-1번째 집은 R 또는 B만 가능
           d[i][G] = min(d[i-1][R], d[i-1][B]) + 초록 비용

        3) i번째 집을 파랑(B)으로 칠하는 경우
           → i-1번째 집은 R 또는 G만 가능
           d[i][B] = min(d[i-1][R], d[i-1][G]) + 파랑 비용

    - 초기 상태
        * d[0][*] = 0
        * 첫 번째 집(i=1)은 이전 집 제약 없이
          각 색의 비용 그대로 시작

    - 최종 답
        * 마지막 집을 어떤 색으로 칠했든 상관없으므로 d[n][R], d[n][G], d[n][B] 중 최솟값 선택
*/
class Ex1149 {



    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] d = new int[n + 1][5];
        final int R = 1, G = 2, B = 3;

        for (int i = 1; i <= n; i++) {
            int r = sc.nextInt();
            int g = sc.nextInt();
            int b = sc.nextInt();

            // i번째 집을 빨강으로 칠하는 경우
            d[i][R] = Math.min(d[i - 1][G], d[i - 1][B]) + r;

            // i번째 집을 초록으로 칠하는 경우
            d[i][G] = Math.min(d[i - 1][R], d[i - 1][B]) + g;

            // i번째 집을 파랑으로 칠하는 경우
            d[i][B] = Math.min(d[i - 1][R], d[i - 1][G]) + b;
        }

        // 마지막 집의 색 선택 중 최소 비용
        System.out.println(Math.min(d[n][R], Math.min(d[n][G], d[n][B])));
    }

}
