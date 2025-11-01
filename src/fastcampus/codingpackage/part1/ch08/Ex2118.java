package fastcampus.codingpackage.part1.ch08;

import java.util.Scanner;

public class Ex2118 {

    public static void main(String[] args) {
        /*
         * 문제 요약
         * - 원형으로 배치된 N개의 탑(그 사이의 구간 거리 distance[i])이 있다.
         * - 임의의 두 탑을 택했을 때, 두 탑 사이의 '최단 거리'는 시계방향 거리와 반시계방향 거리 중 작은 값이다.
         * - 가능한 모든 두 탑 쌍에 대해 이 '최단 거리'의 최대값을 구하라.
         *
         * 핵심 아이디어 (상세)
         * - 기준 탑 i를 고정하고, 상대 탑 pairIndex를 시계방향으로 이동시키며
         *   "시계방향 거리(leftDistance)"와 "반시계방향 거리(rightDistance)"를 동시에 관리한다.
         *
         * - 변수 의미
         *   leftDistance  : i(기준)에서 시작하여 pairIndex 직전까지의 시계방향 누적 거리
         *                   (즉, i에서 pairIndex으로 가는 경로의 길이)
         *   rightDistance : 전체 거리(distanceSum) - leftDistance (반대 방향의 거리)
         *
         * - 불변식(Invariants)
         *   1) leftDistance + rightDistance == distanceSum (항상 성립)
         *   2) leftDistance는 항상 "i에서 pairIndex 직전까지"의 거리 합을 나타냄
         *
         * - 탐색 전략 (왜 작동하는가)
         *   - 두 탑 사이의 실제 최단 거리는 min(leftDistance, rightDistance)이다.
         *   - i를 고정했을 때 leftDistance가 rightDistance보다 작으면,
         *     시계방향 거리를 늘려(= pairIndex를 오른쪽으로 옮겨) min(left, right)를 키울 가능성이 존재한다.
         *     따라서 leftDistance < rightDistance일 때 pairIndex를 이동시켜 leftDistance를 증가시킨다.
         *   - 반대로 leftDistance >= rightDistance이면, 현재 pairIndex 위치에서 이미
         *     left 쪽이 크거나 같은 상태이므로 pairIndex를 더 이동시키면 min(left, right)가 오히려 줄어들 가능성이 크다.
         *     이때는 i를 한 칸 옮겨(기준을 다음 탑으로) 다른 상대를 탐색한다.
         *
         * - 종료와 시간복잡도
         *   - 외부 for 루프에서 i는 0..N-1을 각각 한 번씩 기준으로 삼는다.
         *   - 내부에서 pairIndex는 원형을 따라 계속 증가하지만, pairIndex와 i는 전체 과정에서 각각 최대 O(N)만큼 이동한다.
         *     따라서 총 이동 횟수는 O(N) (두 포인터 기법의 표준 논리).
         *
         * - 엣지케이스
         *   - N == 1: 탑이 하나뿐이면 두 탑을 고를 수 없으므로 문제 조건상 N >= 2인 경우가 일반적이다.
         *   - 모든 거리값이 0인 경우: 결과는 0.
         *
         * 요약: 각 i마다 pairIndex를 while로 이동시켜 'i 기준에서의 최적 상대'를 찾고,
         *       그때의 min(left, right)를 사용해 전체 최대값을 갱신한다.
         */

        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt(); // 탑의 개수
        int[] distance = new int[N]; // 각 구간의 거리 (원형)
        int distanceSum = 0; // 전체 거리 합

        // 입력 및 전체 거리 계산
        for (int i = 0; i < N; i++) {
            distance[i] = sc.nextInt();
            distanceSum += distance[i];
        }

        // 초기 상태 설정: i = 0을 기준으로 시작
        int pairIndex = 1;                  // 오른쪽 포인터: i 기준으로 상대 탑의 인덱스 (처음엔 i+1)
        int leftDistance = distance[0];     // i(=0)에서 pairIndex(=1)까지의 시계방향 거리 (초기: distance[0])
        int rightDistance = distanceSum - leftDistance; // 반대 방향의 거리
        int maxDistance = Math.min(leftDistance, rightDistance); // 현재까지 구한 최댓값 초기화

        // 외부 반복: 기준 탑을 순차적으로 바꾼다 (왼쪽 포인터 역할)
        for (int i = 0; i < N; i++) {

            // ---------------------------
            // 내부 동작: pairIndex(오른쪽 포인터)를 이동시켜 '균형점'을 찾는다.
            // ---------------------------
            // 목적: i를 고정했을 때 leftDistance가 rightDistance보다 짧은 동안
            //       시계방향 거리를 늘려(min(left,right)를 키울 수 있는 후보를 탐색한다.
            //
            // 해석:
            // - leftDistance < rightDistance이면 현재 시계방향 경로가 더 짧다.
            // - 시계방향 경로에 다음 구간 distance[pairIndex]를 더하면 leftDistance가 증가하고
            //   rightDistance가 감소하므로, min(left,right)가 증가할 가능성이 있다.
            // - 이 작업을 반복하면 leftDistance >= rightDistance가 되는 지점(또는 pairIndex가 i로 순환할 때)까지 이동한다.
            //
            // 구현 상의 주의:
            // - pairIndex는 원형이므로 (pairIndex + 1) % N으로 순환시킨다.
            // - 이 while은 항상 종료한다: pairIndex가 한 바퀴 돌아 i로 오더라도 leftDistance가 변화하므로
            //   결국 leftDistance < rightDistance 조건은 깨지거나 pairIndex가 i에 도달한다.
            while (leftDistance < rightDistance) {
                // pairIndex의 구간을 왼쪽(시계) 쪽에 포함시키는 효과
                leftDistance += distance[pairIndex];  // 시계방향 거리 확장
                rightDistance -= distance[pairIndex]; // 반대 방향은 그만큼 축소

                // 원형 이동
                pairIndex = (pairIndex + 1) % N;
            }

            // 현재 i와 pairIndex(직전 포함 범위)의 최단 거리 계산:
            // 두 탑 사이의 실제 최단 거리는 min(leftDistance, rightDistance).
            // 이 값을 전체 최댓값과 비교하여 갱신한다.
            maxDistance = Math.max(maxDistance, Math.min(leftDistance, rightDistance));

            // ---------------------------
            // i를 한 칸 오른쪽으로 이동: 다음 기준 탑(i+1)로 전진
            // ---------------------------
            // 동작:
            // - 현재 i 구간(distance[i])은 더 이상 시계방향 누적(leftDistance)에 포함되지 않으므로 빼준다.
            // - 반시계방향 거리는 그만큼 늘어난다.
            // 이로써 윈도우(기준 i에서 pairIndex 직전까지의 범위)가 한 칸 회전한 것과 같은 효과.
            leftDistance -= distance[i];
            rightDistance += distance[i];
            // (for 루프의 다음 반복에서 i가 증가하고, while문으로 적절히 pairIndex를 다시 이동시킨다.)
        }

        // 결과 출력
        System.out.println(maxDistance);
    }

}
