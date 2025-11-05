package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

/*
 * 💡 [핵심 아이디어 및 접근 원리]
 *
 * - 문제 요약:
 *   문자열이 주어졌을 때, "서로 다른 알파벳의 개수가 N개 이하"인
 *   가장 긴 연속 부분 문자열의 길이를 구하는 문제.
 *
 * - 접근 이유:
 *   1) 연속된 문자열의 범위를 다루므로, **투 포인터(슬라이딩 윈도우)** 기법이 적합하다.
 *   2) 윈도우 내의 서로 다른 알파벳의 개수를 동적으로 관리하면서
 *      가능한 한 긴 구간을 유지해야 한다.
 *   3) 각 알파벳이 등장한 개수를 세기 위해 크기 26의 배열을 사용하여
 *      현재 윈도우에 포함된 알파벳 빈도와 종류를 관리한다.
 *
 * - 핵심 원리:
 *   • 오른쪽 포인터(nextIndex)를 이동시키며 문자를 하나씩 추가하고,
 *     "서로 다른 알파벳 개수"가 N을 초과하면 즉시 중단한다.
 *   • 이때 초과된 문자를 바로 제외하고(포인터를 되돌리기),
 *     조건을 만족하는 구간의 길이를 계산하여 최댓값을 갱신한다.
 *   • 이후 왼쪽 포인터(i)를 한 칸 옮기며 해당 문자의 빈도를 감소시켜
 *     윈도우를 유지한다.
 *
 * - 왜 이 방식이 효율적인가:
 *   모든 문자는 각 포인터에 의해 한 번씩만 증가/감소하므로
 *   전체 알고리즘의 시간 복잡도는 O(N)이다.
 *   (브루트포스로 모든 구간을 탐색하는 O(N²)보다 훨씬 효율적)
 */

public class Ex16472 {

    // 알파벳 등장 빈도 저장 (a~z)
    static int[] currentAlphabetFrequency = new int[26];
    // 현재 윈도우 내의 서로 다른 알파벳 개수
    static int currentUniqueAlphabetCount = 0;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 사용할 수 있는 서로 다른 알파벳의 최대 개수
        char[] nyang = sc.next().toCharArray(); // 문자열 입력
        int nextIndex = 0; // 오른쪽 포인터 (윈도우 끝)
        int maxLength = 0; // 조건을 만족하는 최대 부분 문자열 길이

        // i: 윈도우의 시작 인덱스
        for (int i = 0; i < nyang.length; i++) {
            // 오른쪽 포인터를 가능한 만큼 확장
            while (nextIndex < nyang.length) {
                // 현재 문자를 윈도우에 포함
                increaseFrequency(nyang[nextIndex++]);

                // 만약 서로 다른 알파벳이 N개를 초과하면,
                // 방금 넣은 문자를 되돌리고(제외) 루프 종료
                if (currentUniqueAlphabetCount > N) {
                    decreaseFrequency(nyang[--nextIndex]);
                    break;
                }
            }

            // 조건을 만족하는 현재 구간의 길이로 최댓값 갱신
            maxLength = Math.max(maxLength, nextIndex - i);

            // 왼쪽 포인터가 가리키는 문자를 윈도우에서 제거
            decreaseFrequency(nyang[i]);
        }

        System.out.println(maxLength);
    }

    // 윈도우에 문자를 추가할 때 호출
    static void increaseFrequency(char alphabet) {
        // 해당 문자가 처음 등장한 경우, 서로 다른 알파벳 개수 증가
        if (currentAlphabetFrequency[alphabet - 'a']++ == 0)
            currentUniqueAlphabetCount++;
    }

    // 윈도우에서 문자를 제거할 때 호출
    static void decreaseFrequency(char alphabet) {
        // 해당 문자가 더 이상 존재하지 않으면, 서로 다른 알파벳 개수 감소
        if (--currentAlphabetFrequency[alphabet - 'a'] == 0)
            currentUniqueAlphabetCount--;
    }

}
