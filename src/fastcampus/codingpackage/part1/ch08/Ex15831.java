package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

/*
 * - 문제 요약:
 *   길이가 N인 조약돌 문자열에서,
 *   "검은 조약돌(B)이 B개 이하"이고 "흰 조약돌(W)이 W개 이상"인
 *   연속된 부분 구간의 최대 길이를 구하는 문제이다.
 *
 * - 핵심 원리:
 *   • 오른쪽 포인터(nextIndex)는 가능한 한 멀리 확장하면서 조건을 유지한다. (검은 조약돌이 B개를 넘지 않도록)
 *   • 확장된 상태에서 흰 조약돌이 W개 이상이면 조건을 만족하는 구간이므로 길이를 갱신한다.
 *   • 이후 왼쪽 포인터(i)를 한 칸 옮기며 구간을 좁혀준다.
 *   • 이렇게 하면 모든 구간이 한 번씩만 고려되어 전체 시간 복잡도는 O(N)이 된다.
 *
 */
public class Ex15831 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 전체 조약돌 개수
        int B = sc.nextInt(); // 사용할 수 있는 검은 조약돌의 최대 개수
        int W = sc.nextInt(); // 포함되어야 하는 최소 흰 조약돌 개수
        char[] color = sc.next().toCharArray(); // 조약돌 색상 정보 입력 ('B' 또는 'W')

        int currentWhiteCount = 0; // 현재 구간 내 흰 조약돌 개수
        int currentBlackCount = 0; // 현재 구간 내 검은 조약돌 개수
        int ansLength = 0;         // 조건을 만족하는 구간의 최대 길이
        int nextIndex = 0;         // 오른쪽 포인터 (슬라이딩 윈도우의 끝 지점)

        // i는 구간의 시작 인덱스
        for (int i = 0; i < N; i++) {
            // 오른쪽 포인터를 가능한 만큼 확장
            while (nextIndex < N) {
                // 만약 검은 조약돌이 B개에 도달했고 다음 조약돌이 또 'B'라면 확장 불가
                if (currentBlackCount == B && color[nextIndex] == 'B') break;

                // 다음 조약돌을 윈도우에 포함
                if (color[nextIndex++] == 'W')
                    currentWhiteCount++;
                else
                    currentBlackCount++;
            }

            // 현재 구간의 흰 조약돌이 최소 W개 이상이면 결과 갱신
            if (currentWhiteCount >= W)
                ansLength = Math.max(ansLength, nextIndex - i);

            // 왼쪽 포인터 이동 (i번째 요소 제거)
            if (color[i] == 'W')
                currentWhiteCount--;
            else
                currentBlackCount--;
        }

        // 조건을 만족하는 가장 긴 구간의 길이 출력
        System.out.println(ansLength);
    }

}
