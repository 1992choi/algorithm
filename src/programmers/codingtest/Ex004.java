package programmers.codingtest;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

// 모의고사 - https://school.programmers.co.kr/learn/courses/30/lessons/42840
public class Ex004 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{1, 2, 3, 4, 5})));
        System.out.println(Arrays.toString(solution(new int[]{1, 3, 2, 4, 2})));
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

/*
public static int[] solution(int[] answers) {
    // ① 수포자들의 패턴
    int[][] pattern = {
        {1, 2, 3, 4, 5},
        {2, 1, 2, 3, 2, 4, 2, 5},
        {3, 3, 1, 1, 2, 2, 4, 4, 5, 5}
    };

    // ② 점수 배열
    int[] scores = new int[3];

    // ③ 채점
    for (int i = 0; i < answers.length; i++) {
        for (int j = 0; j < pattern.length; j++) {
            if (answers[i] == pattern[j][i % pattern[j].length]) {
                scores[j]++;
            }
        }
    }

    // ④ 최고 점수
    int maxScore = Arrays.stream(scores).max().getAsInt();

    // ⑤ 결과 리스트
    List<Integer> result = new ArrayList<>();
    for (int i = 0; i < scores.length; i++) {
        if (scores[i] == maxScore) {
            result.add(i + 1);
        }
    }

    // ⑥ 배열로 변환
    return result.stream().mapToInt(Integer::intValue).toArray();
}
 */