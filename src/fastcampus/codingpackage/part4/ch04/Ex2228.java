package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 수열에서 서로 겹치지 않는 M개의 구간을 선택하여 각 구간의 합의 최대값을 구하는 문제
    - 마지막 원소를 반드시 포함하지 않아도 되므로, 현재 위치를 선택하지 않는 경우와 선택하는 경우를 모두 고려
    - DP + 구간 합 + 메모이제이션을 이용한 최적화

  - DP 정의
    - d[n][m] : 1번부터 n번 원소까지 고려했을 때, m개의 구간을 선택해서 얻을 수 있는 최대 합

  - 보조 배열
    - s[i] : 1번부터 i번까지의 누적 합
    - sum(i, j) : i번부터 j번까지의 구간 합 = s[j] - s[i - 1]

  - 점화식
    - 현재 n번째 원소를 선택하지 않는 경우
      d[n][m] = d[n - 1][m]

    - n번째 원소를 포함하는 구간을 하나 선택하는 경우
      마지막 구간의 시작점을 i라고 하면,
      이전 구간은 i - 2 까지만 가능하므로
      d[n][m] = max(d[n][m], d[i - 2][m - 1] + sum(i, n))

  - 기저 조건
    - m == 0 이면 더 이상 구간을 선택하지 않으므로 0 반환
    - n <= 0 인데 m > 0 이면 불가능한 상태이므로 매우 작은 값 반환

  - 최종 정답
    - calc(n, m)

  - 시간 복잡도
    - O(N^2 × M)
*/
class Ex2228 {

    static int[] a, s;
    static int[][] d;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), m = sc.nextInt();

        a = new int[n + 1];
        s = new int[n + 1];
        d = new int[n + 1][m + 1];

        for (int i = 1; i <= n; i++) {
            a[i] = sc.nextInt();
            s[i] = s[i - 1] + a[i];
        }

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= m; j++) {
                d[i][j] = -1;
            }
        }

        System.out.println(calc(n, m));
    }

    static int sum(int[] s, int i, int j) {
        return s[j] - s[i - 1];
    }

    static int calc(int n, int m) {
        if (m == 0) return 0;
        if (n <= 0) return -1000000000;
        if (d[n][m] != -1) return d[n][m];

        d[n][m] = calc(n - 1, m);

        for (int i = 1; i <= n; i++) {
            int temp = calc(i - 2, m - 1) + sum(s, i, n);
            if (d[n][m] < temp) d[n][m] = temp;
        }

        return d[n][m];
    }

}
