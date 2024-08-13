package programmers.lv2;

import java.util.Arrays;

// 프로그래머스 Lv2. 뒤에 있는 큰 수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/154539
public class Ex154539 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{2, 3, 3, 5}))); // [3, 5, 5, -1]
        System.out.println(Arrays.toString(solution(new int[]{9, 1, 5, 3, 6, 2}))); // [-1, 5, 6, 6, -1, -1]
    }

    // 오답 - 23개 중 4개 시간초과
    public static int[] solution(int[] numbers) {
        int[] answer = new int[numbers.length];
        answer[numbers.length - 1] = -1; // 마지막은 자신보다 큰수가 있을 수 없으니 -1로 고정

        for (int i = 0; i < numbers.length - 1; i++) {
            int minValue = Integer.MAX_VALUE;
            for (int j = i + 1; j < numbers.length; j++) {
                if (numbers[i] < numbers[j]) { // 자신보다 뒤에 있는 숫자 중 최소값 찾기
                    minValue = Math.min(numbers[j], minValue);
                    break;
                }
            }

            answer[i] = minValue == Integer.MAX_VALUE ? -1 : minValue;
        }

        return answer;
    }

}

