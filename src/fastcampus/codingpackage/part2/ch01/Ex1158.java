package fastcampus.codingpackage.part2.ch01;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.stream.Collectors;

/*
    [요세푸스 문제 (BOJ 1158) - 큐(Queue) 풀이 핵심 원리]

    1) 1부터 N까지의 사람을 큐에 순서대로 넣는다.
    2) K번째 사람을 제거해야 하므로, (K-1)명은 큐의 맨 뒤로 보낸다.
       → 즉, (K-1)번 동안 q.poll()로 맨 앞 원소를 꺼내 다시 q.add()로 뒤에 넣는다.
    3) 그 다음 순서(q.poll())의 사람이 제거 대상이 되어 결과 배열(ans)에 저장된다.
    4) 큐가 빌 때까지 이 과정을 반복한다.
    5) 모든 제거 순서를 출력 형식에 맞게 "<...>" 형태로 출력한다.

    [예시: N=7, K=3]

    초기 상태: [1, 2, 3, 4, 5, 6, 7]

    1회차
    - (K-1)=2명을 빼서 뒤로 보냄: [3, 4, 5, 6, 7, 1, 2]
    - 제거: 3 → 결과: [3]
    - 큐 상태: [4, 5, 6, 7, 1, 2]

    2회차
    - 2명 회전: [6, 7, 1, 2, 4, 5]
    - 제거: 6 → 결과: [3, 6]
    - 큐 상태: [7, 1, 2, 4, 5]

    3회차
    - 2명 회전: [2, 4, 5, 7, 1]
    - 제거: 2 → 결과: [3, 6, 2]
    - 큐 상태: [4, 5, 7, 1]

    ...

    최종 결과: <3, 6, 2, 7, 5, 1, 4>
*/
public class Ex1158 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int N = sc.nextInt();
        int K = sc.nextInt();

        Queue<Integer> q = new LinkedList<>();
        for (int i = 1; i <= N; i++)
            q.add(i);

        int[] ans = new int[N];
        for (int i = 0; i < N; i++) {
            // (K-1)명은 맨 뒤로 회전시킴
            for (int j = 1; j < K; j++) {
                q.add(q.poll());
            }

            // K번째 사람 제거
            ans[i] = q.poll();
        }

        System.out.print("<" +
                Arrays.stream(ans)
                        .mapToObj(String::valueOf)
                        .collect(Collectors.joining(", ")) +
                ">");
    }

}
