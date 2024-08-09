package programmers.lv2;

import java.util.Comparator;
import java.util.LinkedList;
import java.util.Queue;

// 프로그래머스 Lv2. 프로세스 - https://school.programmers.co.kr/learn/courses/30/lessons/42587
public class Ex42587 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 1, 3, 2}, 2)); // 1
        System.out.println(solution(new int[]{1, 1, 9, 1, 1, 1}, 0)); // 5
        System.out.println(solution(new int[]{5, 4, 3, 2, 1}, 4)); // 5
    }

    public static int solution(int[] priorities, int location) {
        int answer = 1;

        // 작업 큐에 넣기
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.offer(new Process(i, priorities[i]));
        }

        // 작업 시작
        while (!queue.isEmpty()) {
            int maxPriority = queue.stream().max(Comparator.comparingInt(x -> x.priority)).get().priority; // 현재 큐에서 우선순위가 가장 높은 값
            Process process = queue.poll();

            if (process.priority == maxPriority) { // 해당 프로세스 실행
                if (location == process.index) { // 해당 프로세스가 알고자했던 프로세스면 값 리턴
                    return answer;
                }
                answer++;
            } else { // 그렇지 않다면 큐의 제일 마지막에 다시 넣는다.
                queue.offer(process);
            }
        }

        return answer;
    }

}

class Process {

    int index;
    int priority;

    public Process(int index, int priority) {
        this.index = index;
        this.priority = priority;
    }

    @Override
    public String toString() {
        return index + ":" + priority;
    }

}

