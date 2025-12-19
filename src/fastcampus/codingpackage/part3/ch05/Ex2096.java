package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - N행 3열의 숫자들이 주어질 때,
      첫 줄부터 마지막 줄까지 내려오면서 얻을 수 있는
      최댓값과 최솟값을 구하는 문제

    - 이동 규칙
        * 현재 열이 j라면, 다음 행에서는
          j-1, j, j+1 열로만 이동 가능 (범위 내에서)

    - 핵심 아이디어
        * 각 행은 이전 행의 결과에만 의존한다.
        * 전체 DP 테이블을 만들 필요 없이,
          "이전 행"과 "현재 행"만 있으면 충분하다.
        * 따라서 공간 최적화를 위해 1차원 배열을 사용한다.

    - 배열 설명
        * dmx[j] : 이전 행까지 내려왔을 때, j열에서의 최대 합
        * dmn[j] : 이전 행까지 내려왔을 때, j열에서의 최소 합
        * tmx[j] : 현재 행을 반영한 임시 최대 합
        * tmn[j] : 현재 행을 반영한 임시 최소 합

        * 인덱스 1 ~ 3만 실제로 사용
        * 0, 4는 경계 처리용 더미 값

    - 경계 처리 이유
        * j-1, j, j+1을 항상 동일한 로직으로 계산하기 위함
        * 범위를 벗어나는 경우를 따로 분기하지 않도록
          0과 4 위치에 안전한 값 세팅
            - 최대값 계산용: 0
            - 최소값 계산용: 충분히 큰 값

    - 점화식
        * tmx[j] = max(dmx[j-1], dmx[j], dmx[j+1]) + 현재 값
        * tmn[j] = min(dmn[j-1], dmn[j], dmn[j+1]) + 현재 값

    - 처리 흐름
        1) 한 행씩 입력 받는다.
        2) 이전 행(dmx, dmn)을 기준으로 현재 행(tmx, tmn)을 계산한다.
        3) 계산이 끝나면 tmx → dmx, tmn → dmn으로 갱신한다.
        4) 마지막 행까지 처리 후, 1~3열 중 최댓값/최솟값을 선택한다.
*/
class Ex2096 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        final int MAX_VALUE = 1000000;

        int input = 0;

        // 이전 행까지의 최대 / 최소 값
        int[] dmx = new int[5];
        int[] dmn = new int[5];

        // 현재 행 계산용 임시 배열
        int[] tmx = new int[5];
        int[] tmn = new int[5];

        // 경계 처리용 초기값
        dmx[0] = dmx[4] = 0;
        dmn[0] = dmn[4] = MAX_VALUE;

        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= 3; j++) {
                input = sc.nextInt();

                // 최대 합 계산
                tmx[j] = Math.max(dmx[j - 1], Math.max(dmx[j], dmx[j + 1])) + input;

                // 최소 합 계산
                tmn[j] = Math.min(dmn[j - 1], Math.min(dmn[j], dmn[j + 1])) + input;
            }

            // 현재 행 결과를 이전 행 배열로 복사
            for (int j = 1; j <= 3; j++) {
                dmx[j] = tmx[j];
                dmn[j] = tmn[j];
            }
        }

        int max = 0;
        int min = MAX_VALUE;

        // 마지막 행에서 가능한 열 중 최대 / 최소 선택
        for (int i = 1; i <= 3; i++) {
            max = Math.max(max, dmx[i]);
            min = Math.min(min, dmn[i]);
        }

        System.out.println(max + " " + min);
    }

}
