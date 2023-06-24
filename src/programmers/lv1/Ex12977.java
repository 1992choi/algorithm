package programmers.lv1;

import java.util.stream.IntStream;

// 프로그래머스 Lv1. 소수 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12977
public class Ex12977 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{1, 2, 3, 4})); // 1
        System.out.println(solution(new int[]{1, 2, 7, 6, 4})); // 4
    }

    public static int solution(int[] nums) {
        int answer = 0;

        for (int i = 0; i < nums.length - 2; i++) {
            for (int j = i + 1; j < nums.length - 1; j++) {
                for (int k = j + 1; k < nums.length; k++) {
                    int sum = nums[i] + nums[j] + nums[k];
                    if (IntStream.range(1, sum + 1).filter(x -> sum % x == 0).count() == 2) {
                        answer++;
                    }
                }
            }
        }

        return answer;
    }

}
