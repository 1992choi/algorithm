package fastcampus.codingpackage.part1.ch09;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * [요세푸스 문제 풀이 핵심 원리]
 *
 * 1) 사람들을 1~N까지 리스트로 저장한다.
 * 2) 이전 제거 인덱스(pastIdx)에서 시작해, K번째 사람의 인덱스를 계산한다.
 *    → (pastIdx + K - 1) % 현재 리스트 크기
 * 3) 해당 사람을 리스트에서 제거하고 결과 배열(ans)에 저장한다.
 * 4) 제거 후, 방금 제거한 인덱스를 다음 탐색의 시작점으로 설정한다.
 * 5) 리스트가 빌 때까지 반복한다.
 *
 * [시뮬레이션 예시: N = 7, K = 3]
 *
 * 1회차
 * - 현재 리스트: [1, 2, 3, 4, 5, 6, 7]
 * - pastIdx = 0
 * - 제거 인덱스 = (0 + 3 - 1) % 7 = 2 → 값 3 제거
 * - 결과 리스트: [1, 2, 4, 5, 6, 7]
 * - pastIdx = 2
 *
 * 2회차
 * - 현재 리스트: [1, 2, 4, 5, 6, 7]
 * - pastIdx = 2 (즉, 4번 자리부터 시작)
 * - 제거 인덱스 = (2 + 3 - 1) % 6 = 4 → 값 6 제거
 * - 결과 리스트: [1, 2, 4, 5, 7]
 * - pastIdx = 4
 *
 * 3회차
 * - 현재 리스트: [1, 2, 4, 5, 7]
 * - pastIdx = 4 (즉, 7번 자리부터 시작)
 * - 제거 인덱스 = (4 + 3 - 1) % 5 = 1 → 값 2 제거
 * - 결과 리스트: [1, 4, 5, 7]
 * - pastIdx = 1
 */
public class Ex1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 전체 사람 수
        int K = sc.nextInt(); // 제거할 순서 간격

        // 사람 번호를 1부터 N까지 리스트에 추가
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= N; i++) {
            list.add(i);
        }

        int[] ans = new int[N]; // 제거된 사람 순서를 저장할 배열
        int pastIdx = 0;        // 이전 제거 인덱스 (다음 탐색의 시작점)
        for (int i = 0; i < N; i++) {
            // 다음 제거 대상 인덱스 계산 (원형 순회)
            int targetIdx = (pastIdx + K - 1) % list.size();

            // 리스트에서 해당 인덱스의 사람을 제거하고 결과에 저장
            ans[i] = list.remove(targetIdx);

            // 제거한 인덱스부터 다음 탐색 시작
            pastIdx = targetIdx;
        }

        System.out.println(
                "<" + Arrays.stream(ans)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) + ">"
        );
    }

}
