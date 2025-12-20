package fastcampus.codingpackage.part3.ch05;

import java.util.Scanner;

/*
    풀이

    - 각 날짜마다 상담을 할지 / 하지 않을지를 선택하는 문제
    - 상담은 연속된 기간(t[i])을 차지하며, 해당 상담이 끝나는 날에 이익 p[i]를 얻는다.

    - 핵심 아이디어
        - "i번째 날까지 얻을 수 있는 최대 수익"을 기준으로 DP를 진행
        - 날짜를 하나씩 증가시키면서
          1) 오늘 아무 것도 하지 않는 경우
          2) 오늘 상담을 시작하는 경우
          를 동시에 갱신

    - DP 정의
        d[i] : i번째 날까지(정확히는 i일 시작 시점까지)
               얻을 수 있는 최대 수익

    - 점화식 설명
        1) 상담을 하지 않는 경우
           - 이전 날까지의 최대 수익을 그대로 가져온다
           - d[i] = max(d[i], d[i - 1])

        2) i번째 날에 상담을 시작하는 경우
           - 상담이 끝나는 날은 i + t[i]
           - 퇴사일(n + 1)을 넘어가면 불가능
           - 가능하다면
             d[i + t[i]] = max(d[i + t[i]], d[i] + p[i])

    - 왜 n + 1까지 사용하는가?
        - n일까지 상담을 진행하고, 실제 수익은 "n+1일"에 확정되기 때문
        - 따라서 최종 정답은 d[n + 1]

    - 이 방식의 장점
        - 뒤에서부터 계산하는 방식보다 직관적
        - 하루 단위로 최적해를 누적해 나가는 구조
*/
class Ex15486 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] t = new int[n + 2];
        int[] p = new int[n + 2];
        int[] d = new int[n + 2];

        for (int i = 1; i <= n; i++) {
            t[i] = sc.nextInt();
            p[i] = sc.nextInt();
        }

        for (int i = 1; i <= n + 1; i++) {
            d[i] = Math.max(d[i - 1], d[i]);

            if (i + t[i] > n + 1) continue;
            d[i + t[i]] = Math.max(d[i + t[i]], d[i] + p[i]);
        }

        System.out.println(d[n + 1]);
    }

}
