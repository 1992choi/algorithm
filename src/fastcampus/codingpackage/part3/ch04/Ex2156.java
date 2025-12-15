package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 연속으로 3잔을 마실 수 없다는 제약이 있는 최대 합 DP 문제
    - 각 잔을 기준으로, "현재 잔을 어떤 상태로 마셨는지"를 상태로 분리해서 관리한다.

    - DP 상태 정의
        d[0][i]: i번째 잔을 마시지 않은 경우의 최대 값
        d[1][i]: i번째 잔을 마셨고, 직전(i-1) 잔은 마시지 않은 경우
        d[2][i]: i번째 잔을 마셨고, 직전(i-1) 잔도 마신 경우
                 (즉, 연속으로 2잔 마신 상태)

    - 이 상태 정의의 핵심
        * 연속 3잔을 마시는 경우는 애초에 상태로 만들지 않는다.
        * d[2] 다음에 또 마시는 경우는 전이 자체가 불가능하도록 설계됨.
        * 따라서 별도의 예외 처리 없이 제약을 자연스럽게 만족한다.

    - 점화식

        1) i번째 잔을 마시지 않는 경우
           → 이전 상태가 무엇이든 상관없이 최대값을 가져온다.
           d[0][i] = max(d[0][i-1], d[1][i-1], d[2][i-1])

        2) i번째 잔을 마시고, 연속 1잔 상태
           → 직전 잔은 반드시 마시지 않은 상태여야 한다.
           d[1][i] = d[0][i-1] + wine[i]

        3) i번째 잔을 마시고, 연속 2잔 상태
           → 직전 잔은 연속 1잔 상태여야 한다.
           d[2][i] = d[1][i-1] + wine[i]

    - 초기값
        d[0][1] = 0
        d[1][1] = wine[1]
        d[2][1] = wine[1]
        (첫 잔은 연속 여부와 무관하게 동일한 값이 된다)
*/
class Ex2156 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] wine = new int[n + 1];
        int[][] d = new int[3][n + 1];
        for (int i = 1; i <= n; i++) {
            wine[i] = sc.nextInt();
        }

        d[0][1] = 0;
        d[1][1] = wine[1];
        d[2][1] = wine[1];

        for (int i = 2; i <= n; i++) {
            d[0][i] = Math.max(d[0][i - 1], Math.max(d[1][i - 1], d[2][i - 1]));
            d[1][i] = d[0][i - 1] + wine[i];
            d[2][i] = d[1][i - 1] + wine[i];
        }

        System.out.println(Math.max(d[0][n], Math.max(d[1][n], d[2][n])));
    }

}
