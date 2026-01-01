package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 두 개의 소리 배열 sound1, sound2를 처음부터 끝까지 맞춰가며 비용의 최솟값을 DP로 계산
    - i번째 소리와 j번째 소리를 맞추는 최소 비용을 d[i][j]로 정의
    - 이전 상태에서 한 칸씩 이동하며 세 가지 경우 중 최소값을 선택

  - DP 정의
    d[i][j] : sound1의 앞 i개와 sound2의 앞 j개를 맞추는 최소 비용

  - 초기값
    - 아무 소리도 사용하지 않은 상태 d[0][0] = 0
    - 그 외의 상태는 매우 큰 값(INF)으로 초기화하여 최소 비교가 가능하도록 설정

  - 점화식
    - (i, j) 상태는 다음 세 경우 중 하나에서 올 수 있음
      1) sound1[i]와 sound2[j]를 서로 맞춘 경우 → d[i - 1][j - 1]
      2) sound1[i]를 건너뛴 경우 → d[i - 1][j]
      3) sound2[j]를 건너뛴 경우 → d[i][j - 1]
    - 위 세 값 중 최소값에 현재 두 소리의 차이 비용을 더함
      d[i][j] = min(d[i - 1][j - 1], d[i - 1][j], d[i][j - 1]) + (sound1[i] - sound2[j])²

  - 전체 정답
    - d[n][n] 값이 두 소리 배열을 끝까지 맞췄을 때의 최소 비용

  - 시간 복잡도
    - O(N²)
*/
class Ex15822 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] sound1 = new int[n + 1];
        int[] sound2 = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            sound1[i] = sc.nextInt();
        }
        for (int i = 1; i <= n; i++) {
            sound2[i] = sc.nextInt();
        }

        int[][] d = new int[n + 1][n + 1];
        final int INF = 1000000000;

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= n; j++) {
                d[i][j] = INF;
            }
        }

        d[0][0] = 0;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= n; j++) {
                d[i][j] = min3(
                        d[i - 1][j - 1],
                        d[i - 1][j],
                        d[i][j - 1]
                ) + diff(sound1[i], sound2[j]);
            }
        }

        System.out.println(d[n][n]);
    }

    static int diff(int a, int b) {
        return (a - b) * (a - b);
    }

    static int min3(int a, int b, int c) {
        return Math.min(a, Math.min(b, c));
    }

}
