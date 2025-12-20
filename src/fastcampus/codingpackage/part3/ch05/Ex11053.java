package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 각 위치 i를 끝으로 하는 LIS의 길이를 DP로 관리
    - i보다 앞에 있는 원소들 중 arr[j] < arr[i] 인 경우만 연결 가능

  - DP 정의
    - d[i] : i번째 원소를 마지막으로 사용하는 가장 긴 증가하는 부분 수열의 길이

  - 초기값
    - 자기 자신 하나만 선택하는 경우는 항상 가능하므로 d[i] = 1

  - 점화식
    - i보다 앞에 있는 모든 j(1 ≤ j < i)에 대해
    - arr[j] < arr[i] 라면 d[i] = max(d[i], d[j] + 1)

  - 전체 정답
    - 모든 d[i] 중 최댓값이 LIS의 길이

  - 시간 복잡도
    - O(N^2)
*/
class Ex11053 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n + 1];
        int[] d = new int[n + 1];

        for (int i = 1; i <= n; i++) {
            arr[i] = sc.nextInt();
        }

        int max = 1;
        for (int i = 1; i <= n; i++) {
            d[i] = 1;
            for (int j = 1; j < i; j++) {
                if (arr[j] < arr[i]) {
                    d[i] = Math.max(d[i], d[j] + 1);
                }
            }
            max = Math.max(max, d[i]);
        }

        System.out.println(max);
    }

}
