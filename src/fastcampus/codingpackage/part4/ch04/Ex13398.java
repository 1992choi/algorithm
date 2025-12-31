package fastcampus.codingpackage.part4.ch04;

import java.util.Scanner;

/*
  - 핵심 아이디어
    - 연속합 문제에서 한 번의 원소 삭제를 허용하는 경우를 DP로 확장
    - 삭제를 하지 않은 상태와 삭제를 이미 한 상태를 구분하여 관리

  - DP 정의
    - d[0][i] : i번째 원소까지 고려했을 때 삭제를 하지 않고 i번째 원소를 포함하는 최대 연속합
    - d[1][i] : i번째 원소까지 고려했을 때 원소를 하나 삭제했고 i번째 원소를 포함하는 최대 연속합

  - 초기값
    - d[0][0] = a[0] : 첫 번째 원소만 선택하는 경우
    - d[1][0] 은 의미가 없으므로 사용하지 않음

  - 점화식
    - d[0][i] = max(d[0][i - 1], 0) + a[i]
      → 이전 연속합을 이어가거나, 새로 시작하거나 선택
    - d[1][i] = max(d[0][i - 1], d[1][i - 1] + a[i])
      → 현재 원소를 삭제하는 경우(d[0][i - 1]) 또는 이미 삭제했고 현재를 포함하는 경우

  - 전체 정답
    - 모든 i에 대해 d[0][i], d[1][i] 중 최대값이 정답

  - 시간 복잡도
    - O(N)
    - 한 번의 순회로 해결 가능
*/
class Ex13398 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[][] d = new int[2][n];
        int[] a = new int[n];

        for (int i = 0; i < n; i++) {
            a[i] = sc.nextInt();
        }

        d[0][0] = a[0];
        int ans = d[0][0];

        for (int i = 1; i < n; i++) {
            d[0][i] = Math.max(d[0][i - 1], 0) + a[i];
            d[1][i] = Math.max(d[0][i - 1], d[1][i - 1] + a[i]);
            ans = Math.max(ans, Math.max(d[0][i], d[1][i]));
        }

        System.out.println(ans);
    }

}
