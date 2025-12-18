package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - 2×N 우리에 사자를 배치하는 경우의 수를 구하는 문제
    - 한 칸에는 사자를 1마리만 둘 수 있고, 가로/세로로 인접한 칸에 사자를 동시에 둘 수 없다.

    - 상태 정의
        * d[LEFT][i]  : i번째 열에 왼쪽 칸에만 사자를 둔 경우
        * d[RIGHT][i] : i번째 열에 오른쪽 칸에만 사자를 둔 경우
        * d[NONE][i]  : i번째 열에 사자를 두지 않은 경우

    - 핵심 아이디어
        * 각 열의 상태는 바로 이전 열의 상태에만 영향을 받는다.
        * 같은 열에서는 좌우에 동시에 사자를 둘 수 없고,
          이전 열과도 인접 제약이 있기 때문에 가능한 이전 상태만 이어받는다.

    - 점화식
        * d[LEFT][i]
            - 이전 열에서 오른쪽만 있거나, 아무것도 없는 경우만 가능
        * d[RIGHT][i]
            - 이전 열에서 왼쪽만 있거나, 아무것도 없는 경우만 가능
        * d[NONE][i]
            - 이전 열이 어떤 상태든 가능

    - 초기값 (i = 1)
        * 왼쪽만 배치, 오른쪽만 배치, 아무것도 안 배치 → 모두 1가지

    - 최종 결과
        * N번째 열의 모든 상태를 합한 값
*/
class Ex1309 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        final int NONE = 0;
        final int LEFT = 1;
        final int RIGHT = 2;

        int n = sc.nextInt();
        int[][] d = new int[3][n + 1];

        d[LEFT][1] = 1;
        d[RIGHT][1] = 1;
        d[NONE][1] = 1;

        for (int i = 2; i <= n; i++) {
            d[LEFT][i] = (d[RIGHT][i - 1] + d[NONE][i - 1]) % 9901;
            d[RIGHT][i] = (d[LEFT][i - 1] + d[NONE][i - 1]) % 9901;
            d[NONE][i] = (d[LEFT][i - 1] + d[RIGHT][i - 1] + d[NONE][i - 1]) % 9901;
        }
        System.out.println((d[LEFT][n] + d[RIGHT][n] + d[NONE][n]) % 9901);
    }

}
