package fastcampus.codingpackage.part4.ch01;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

/*
  풀이

  - 핵심 아이디어
    - 회의를 시작 시간 기준으로 정렬한 뒤, 현재 진행 중인 회의들을 우선순위 큐로 관리한다
    - 우선순위 큐에는 "끝나는 시간이 가장 빠른 회의"가 먼저 나오도록 한다
    - 새로운 회의가 시작될 때, 이미 끝난 회의들은 큐에서 제거한다
    - 큐에 남아 있는 회의 개수는 현재 동시에 진행 중인 회의 개수이다

  - 정렬 기준
    - 시작 시간이 빠른 순
    - 시작 시간이 같다면 종료 시간이 빠른 순

  - 우선순위 큐 역할
    - 현재 진행 중인 회의들만 저장
    - 종료 시간이 가장 빠른 회의를 빠르게 확인하고 제거하기 위함

  - 정답 갱신
    - 매 회의 처리 시점에서 큐의 크기가 필요한 최소 회의실 개수
    - 그 중 최대값이 최종 답
*/
class Ex19598 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        List<Meeting> meeting = new ArrayList<>();

        // 모든 회의의 시작 시간과 종료 시간을 입력받아 리스트에 저장
        for (int i = 0; i < n; i++) {
            meeting.add(new Meeting(sc.nextInt(), sc.nextInt()));
        }

        // 시작 시간을 기준으로 정렬, 시작 시간이 같으면 종료 시간 기준 정렬
        meeting.sort((o1, o2) -> {
            if (o1.start == o2.start) return o1.end - o2.end;
            return o1.start - o2.start;
        });

        // 종료 시간이 가장 빠른 회의가 먼저 나오도록 하는 우선순위 큐
        PriorityQueue<Meeting> pq = new PriorityQueue<>((o1, o2) -> {
            return o1.end - o2.end;
        });

        int ans = 1;

        for (Meeting m : meeting) {
            // 아직 진행 중인 회의가 없다면 바로 추가
            if (pq.isEmpty()) {
                pq.offer(m);
                continue;
            }

            // 현재 회의 시작 시간 이전에 끝난 회의들은 더 이상 회의실을 차지하지 않으므로 제거
            while (!pq.isEmpty() && pq.peek().end <= m.start) pq.poll();

            // 현재 회의를 진행 중인 회의 목록에 추가
            pq.offer(m);

            // 현재 동시에 진행 중인 회의 수로 최대값 갱신
            ans = Math.max(ans, pq.size());
        }

        System.out.println(ans);
    }

    static class Meeting {
        int start;
        int end;

        public Meeting(int start, int end) {
            this.start = start;
            this.end = end;
        }
    }

}
