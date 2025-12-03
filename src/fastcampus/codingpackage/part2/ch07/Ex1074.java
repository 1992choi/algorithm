package fastcampus.codingpackage.part2.ch07;

import java.util.Scanner;

/*
    풀이
    - 2^n × 2^n 크기의 Z-모양 탐색(Z-order curve)에서 특정 좌표 (r, c)가 몇 번째로 방문되는지 계산하는 문제
    - Z순서는 항상 4개의 사분면을 다음과 같은 고정된 순서로 방문함
        0) 좌상단 → 1) 우상단 → 2) 좌하단 → 3) 우하단
    - 현재 좌표가 속하지 않은 사분면들은 그 사분면 전체가 이미 방문된 상태이므로
      해당 사분면의 칸 수(mid * mid)를 count에 한 번에 더하고 재귀적으로 넘어갈 수 있음
    - 탐색 범위를 절반으로 줄여가는 방식이므로 시간복잡도는 O(n)
*/
class Ex1074 {

    public static int n, r, c;
    public static int count = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        r = sc.nextInt();
        c = sc.nextInt();
        solve(n, r, c);
        System.out.println(count);
    }

    public static void solve(int n, int r, int c) {
        int boardSize = 1 << n; // 2^n
        int mid = boardSize / 2;

        // n == 0이면 더 이상 쪼갤 필요 없음 (크기 1×1)
        if (n == 0) return;

        // 좌상단 (0번 사분면)
        if (r < mid && c < mid) {
            /*
                0번 사분면은 Z순서에서 가장 먼저 방문됨.
                현재 좌표가 여기에 속하므로 count 추가 없이 그대로 재귀 진행.
            */
            solve(n - 1, r, c);
        }
        // 우상단 (1번 사분면)
        else if (r < mid && c >= mid) {
            /*
                1번 사분면에 도달하기 전에 0번 사분면 전체가 이미 방문됨.
                0번 사분면의 격자 수 = mid * mid
                → 따라서 그 수만큼 count를 한 번에 더할 수 있음.
            */
            count += mid * mid;
            solve(n - 1, r, c - mid);
        }
        // 좌하단 (2번 사분면)
        else if (r >= mid && c < mid) {
            /*
                Z순서 방문 순서:
                0) 좌상단 → 1) 우상단 → 2) 좌하단
                → 즉, 2번 사분면에 오기 전에 0, 1번 사분면이 모두 방문됨.

                그 크기 = 2 × (mid * mid)
            */
            count += mid * mid * 2;
            solve(n - 1, r - mid, c);
        }
        // 우하단 (3번 사분면)
        else {
            /*
                3번 사분면 도달 전:
                    0번, 1번, 2번 사분면이 모두 방문됨
                → 따라서 3 × (mid * mid)를 모두 count에 더함
            */
            count += mid * mid * 3;
            solve(n - 1, r - mid, c - mid);
        }
    }

}
