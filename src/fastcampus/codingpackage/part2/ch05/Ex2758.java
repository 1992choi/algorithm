package fastcampus.codingpackage.part2.ch05;

import java.util.Scanner;

/*
    풀이

    - 조건을 만족하는 길이 n 수열의 개수를 구하기 위해 "마지막 값이 어떤 범위까지 가능한가"를 기준으로 DP를 구성한다.

    - solve(i, last):
        i개의 값을 선택해야 하고, 마지막 값이 last 이하일 때 만들 수 있는 경우의 수.

    - 점화식의 핵심 흐름:
        1) 마지막 값을 last로 선택하는 경우
        2) last를 선택하지 않고 가능한 최대값을 줄이는 경우
      → 두 경우를 더하는 형태로 수열 개수를 누적한다.
*/
class Ex2758 {

    public static long[][] mem;

    public static long solve(int i, int last) {
        if (last <= 0) return 0;
        if (i == 1) return last;
        if (mem[i][last] == -1) {
            // 마지막 값을 last로 쓰는 경우 + 쓰지 않고 last를 줄여서 계산
            mem[i][last] = solve(i - 1, last / 2) + solve(i, last - 1);
        }
        return mem[i][last];
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();
        for (int tc = 0; tc < t; tc++) {
            int n = sc.nextInt();
            int m = sc.nextInt();
            mem = new long[n + 1][m + 1];

            for (int i = 0; i < n + 1; i++) {
                for (int j = 0; j < m + 1; j++) {
                    mem[i][j] = -1;
                }
            }


            System.out.println(solve(n, m));
        }
    }

}