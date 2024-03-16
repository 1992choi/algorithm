package programmers.lv3;

import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.Queue;

// 프로그래머스 Lv3. 이중우선순위큐 - https://school.programmers.co.kr/learn/courses/30/lessons/42628
public class Ex42628 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new String[]{"I 16", "I -5643", "D -1", "D 1", "D 1", "I 123", "D -1"}))); // [0,0]
        System.out.println(Arrays.toString(solution(new String[]{"I -45", "I 653", "D 1", "I -642", "I 45", "I 97", "D 1", "D -1", "I 333"}))); // [333, -45]
    }

    public static int[] solution(String[] operations) {
        int[] answer = new int[2];
        Queue<Integer> queue = new PriorityQueue<>(Comparator.reverseOrder());

        for (String operation : operations) {
            String cmd = operation.split(" ")[0];
            int value = Integer.parseInt(operation.split(" ")[1]);

            if ("I".equals(cmd)) { // 큐에 주어진 숫자를 삽입
                queue.offer(value);
            } else {
                if (value == -1) { // 큐에서 최솟값을 삭제
                    if (!queue.isEmpty()) {
                        queue.remove(queue.stream().min(Integer::compareTo).get());
                    }
                } else if (value == 1) { // 큐에서 최댓값을 삭제
                    queue.poll();
                }
            }
        }

        // 최종 판단
        if (!queue.isEmpty()) {
            answer[0] = queue.poll();
            if (!queue.isEmpty()) { // 최종 판단 시, 데이터가 1개 남아있는 경우를 위한 처리
                answer[1] = queue.stream().min(Integer::compareTo).get();
            } else {
                answer[1] = answer[0];
            }
        }

        return answer;
    }

}
