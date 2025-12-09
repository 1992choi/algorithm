package fastcampus.codingpackage.part3.ch02;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

/*
    풀이

    - 시작점 n에서 k까지 이동하는 최소 시간을 구하는 BFS 문제.
    - BFS는 먼저 도착한 순간이 최단 거리이므로, visited[x]에는 "x에 도달하는 데 걸린 시간 + 1"이 저장된다.
    - visited 배열을 0으로 초기화한 뒤, 방문 여부 판별을 위해 visited[n] = 1로 시작한다.
      → 즉, 실제 이동 시간은 visited 값에서 -1을 해야 실제 걸린 시간이 된다.
*/
class Ex1697 {

    static int n, k;
    static int[] visited = new int[100001];

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        n = sc.nextInt();
        k = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        q.add(n);
        visited[n] = 1;
        while (!q.isEmpty()) {
            int now = q.poll();
            if (now == k) break;
            int[] next = {now - 1, now + 1, now * 2};
            for (int i = 0; i < 3; i++) {
                if (!isRange(next[i])) continue;
                if (visited[next[i]] == 0) {
                    visited[next[i]] = visited[now] + 1;
                    q.add(next[i]);
                }
            }
        }

        System.out.println(visited[k] - 1);
    }

    static boolean isRange(int x) {
        return x >= 0 && x <= 100000;
    }

}

