package fastcampus.codingpackage.part4.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 핵심 아이디어
        - 건물 간 선후 관계가 존재하므로 위상 정렬을 사용
        - 각 건물을 완성하는 데 걸리는 최소 시간을 DP로 관리
        - 어떤 건물은 여러 선행 건물을 가질 수 있으므로,
          가장 오래 걸리는 경로를 기준으로 시간을 계산

    - 그래프 모델링
        - a → b : a를 먼저 지어야 b를 지을 수 있음
        - indegree[b] : b를 짓기 전에 필요한 선행 건물 수

    - DP 정의
        dp[i] : i번 건물을 완성하는 데 걸리는 최소 시간

    - 초기값
        - 진입 차수가 0인 건물은 바로 지을 수 있으므로
          dp[i] = time[i]

    - 점화식
        - now → next 관계일 때
          dp[next] = max(dp[next], dp[now] + time[next])

    - 처리 방식
        - 위상 정렬(BFS)을 진행하면서
        - indegree가 0이 되는 시점에 큐에 삽입

    - 정답
        - 목표 건물 W에 대한 dp[W]

*/
class Ex1005 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t = sc.nextInt();

        while (t-- > 0) {
            int n = sc.nextInt();
            int k = sc.nextInt();

            int[] time = new int[n + 1];
            int[] dp = new int[n + 1];
            int[] indegree = new int[n + 1];
            int[][] adj = new int[n + 1][n + 1];

            for (int i = 1; i <= n; i++) {
                time[i] = sc.nextInt();
            }

            for (int i = 0; i < k; i++) {
                int a = sc.nextInt();
                int b = sc.nextInt();
                adj[a][b] = 1;
                indegree[b]++;
            }

            Queue<Integer> q = new LinkedList<>();

            for (int i = 1; i <= n; i++) {
                if (indegree[i] == 0) {
                    q.offer(i);
                    dp[i] = time[i];
                }
            }

            while (!q.isEmpty()) {
                int now = q.poll();

                for (int next = 1; next <= n; next++) {
                    if (adj[now][next] == 1) {
                        indegree[next]--;
                        dp[next] = Math.max(dp[next], dp[now] + time[next]);
                        if (indegree[next] == 0) {
                            q.offer(next);
                        }
                    }
                }
            }

            int w = sc.nextInt();
            System.out.println(dp[w]);
        }
    }

}
