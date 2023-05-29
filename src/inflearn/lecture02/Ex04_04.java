package inflearn.lecture02;

import java.util.Arrays;

public class Ex04_04 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{99, 97, 80, 91, 85, 95, 92}, 3)); // 89
        System.out.println(solution(new int[]{92, 90, 77, 91, 70, 83, 89, 76, 95, 92}, 4)); // 88
        System.out.println(solution(new int[]{77, 88, 78, 80, 78, 99, 98, 92, 93, 89}, 5)); // 92
        System.out.println(solution(new int[]{88, 99, 91, 89, 90, 72, 75, 94, 95, 100}, 5)); // 90
    }

    public static int solution(int[] score, int k) {
        int answer = Integer.MAX_VALUE;

        /**
             평균 값이 작은 값을 찾는 것이므로,
             오름차순 정렬을 한 후 k만큼 연달아 있는 수의 평균 구하기.
             *** 연달아 있지 않다면, 가장 높은 점수와 가장 낮은 점수의 차가 10점을 넘길 확률이 높음
         */

        // 정렬
        Arrays.sort(score);

        for (int i = 0; i < score.length - (k - 1); i++) {
            int sum = 0;
            int max = Integer.MIN_VALUE;
            int min = Integer.MAX_VALUE;

            // k만큼 연이은 수의 최댓값, 최소값, 합 구하기
            for (int j = 0; j < k; j++) {
                sum += score[i + j];
                max = Math.max(max, score[i + j]);
                min = Math.min(min, score[i + j]);
            }

            // 차이가 10 이하일 때만 평균 내기
            if (max - min <= 10) {
                answer = Math.min(answer, sum / k);
            }
        }

        return answer;
    }

}
