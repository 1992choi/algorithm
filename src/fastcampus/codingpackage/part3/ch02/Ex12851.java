package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - n에서 k까지의 "최단 시간" + "최단 시간으로 도착하는 경우의 수"를 구하는 BFS 문제.
    - BFS 특성상 가장 먼저 목표 지점에 도달한 시간이 최단 시간이 된다.

    - visited[x] : x에 도달하는 데 걸린 시간 + 1
      → 방문 여부 판별을 위해 0이 아닌 값을 기록해야 하므로 visited[n] = 1로 시작
      → 실제 이동 시간은 visited[k] - 1

    - count[x] : x에 도달하는 "최단 경로의 수"
      → 어떤 노드에 최초로 도달하면, count[next] = count[now]
      → 이후 동일한 최단 시간(visited[next] == visited[now] + 1)으로 또 도달하면,
        count[next] += count[now] 를 통해 경우의 수 누적

    - 중요한 점:
      → visited[next] < visited[now] + 1: 이미 더 짧은 시간이 있으므로 무시
      → visited[next] > visited[now] + 1: 최초 도달이므로 시간 기록 + count 설정
      → visited[next] == visited[now] + 1: 동일 최단 시간 도달 → 경우의 수 누적

    - BFS에서 now == k 순간 즉시 종료해도 되는 이유:
      → BFS는 레벨(시간) 단위 탐색이므로 처음 k에 도달하는 순간 이미 최단 시간임이 보장된다.
*/
class Ex12851 {

    static int n, k;
    static int[] visited = new int[100001];
    static int[] count = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;   // 실제 시간 0이지만 방문 여부 체크를 위해 1로 설정
        count[n] = 1;     // 시작점에 도달하는 방법은 1가지

        while (!q.isEmpty()) {
            int now = q.poll();

            // 최초 k 도달 순간, 이미 BFS 특성상 최단 거리
            if (now == k) break;

            int[] next = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                int nx = next[i];
                if (!isRange(nx)) continue;

                if (visited[nx] == 0) {
                    // 최초 방문 → 최단 시간 기록
                    visited[nx] = visited[now] + 1;
                    count[nx] = count[now];   // 현재 경로 수를 그대로 물려받음
                    q.add(nx);
                }
                else if (visited[nx] == visited[now] + 1) {
                    // 이미 최단 시간으로 도달한 적 있음 → 경로 추가
                    count[nx] += count[now];
                }
            }
        }

        System.out.println(visited[k] - 1); // 실제 이동 시간
        System.out.println(count[k]);      // 최단 거리로 도달하는 경우의 수
    }

    static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }

}
