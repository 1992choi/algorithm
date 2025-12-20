package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - 위에서 아래로 내려오면서 숫자를 하나씩 선택
    - 현재 위치 (i, j)에 도달할 수 있는 경로는 항상 두 가지뿐
        - 바로 위 왼쪽: (i - 1, j - 1)
        - 바로 위 오른쪽: (i - 1, j)

    - 삼각형 구조 특성상
        - j == 1 인 경우: (i - 1, j)에서만 내려올 수 있음
        - j == i 인 경우: (i - 1, j - 1)에서만 내려올 수 있음
        - 그 외에는 두 위치 중 최대값 선택

    - DP 정의
        d[i][j] : i번째 줄의 j번째 수를 선택했을 때,
                  꼭대기부터 여기까지 내려온 숫자 합의 최댓값

    - 점화식
        d[i][j] = max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j]

    - 초기값
        d[1][1] = a[1][1]

    - 마지막 줄에서의 최댓값이 정답
*/
class Ex1932 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] a = new int[n + 1][n + 1];
        int[][] d = new int[n + 1][n + 1];

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                a[i][j] = sc.nextInt();
            }
        }

        d[1][1] = a[1][1];

        for (int i = 2; i <= n; i++) {
            for (int j = 1; j <= i; j++) {
                d[i][j] = Math.max(d[i - 1][j - 1], d[i - 1][j]) + a[i][j];
            }
        }

        int ans = 0;
        for (int i = 1; i <= n; i++) {
            ans = Math.max(ans, d[n][i]);
        }

        System.out.println(ans);
    }

}
