package programmers.lv1;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 프로그래머스 Lv1. 모의고사 - https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Ex42840 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5}))); // [1]
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2}))); // [1,3,2,4,2]
    }

    public static int[] solution(int[] answers) {
        // 수포자들의 답 패턴과 점수 초기화
        int[] student1 = {1, 2, 3, 4, 5};
        int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
        int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};
        int[] score = new int[3];

        // 문제 진행
        for (int i = 0; i < answers.length; i++) {
            if (answers[i] == student1[i % student1.length]) {
                score[0]++;
            }
            if (answers[i] == student2[i % student2.length]) {
                score[1]++;
            }
            if (answers[i] == student3[i % student3.length]) {
                score[2]++;
            }
        }

        // 최고점과 최고점인 학생 반환
        List<Integer> list = new ArrayList<>();
        int maxScore = Arrays.stream(score).max().getAsInt();
        for (int i = 0; i < 3; i++) {
            if (score[i] == maxScore) {
                list.add(i + 1);
            }
        }

        return list.stream().mapToInt(i -> i).toArray();
    }

}