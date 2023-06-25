package programmers.lv1;

import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

// 프로그래머스 Lv1. 명예의 전당 (1) - https://school.programmers.co.kr/learn/courses/30/lessons/138477
public class Ex138477 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(3, new int[]{10, 100, 20, 150, 1, 100, 200}))); // [10, 10, 10, 20, 20, 100, 100]
        System.out.println(Arrays.toString(solution(4, new int[]{0, 300, 40, 300, 20, 70, 150, 50, 500, 1000}))); // 0, 0, 0, 0, 20, 40, 70, 70, 150, 300
    }

    public static int[] solution(int k, int[] score) {
        int[] answer = new int[score.length];
        Queue<Integer> queue = new PriorityQueue<>();

        for (int i = 0; i < score.length; i++) {
            queue.add(score[i]);
            if (queue.size() > k) {
                queue.poll();
            }
            answer[i] = queue.peek();
        }

        return answer;
    }

}
