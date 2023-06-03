package programmers.lv1;

import java.util.Arrays;

// 프로그래머스 Lv1. 나누어 떨어지는 숫자 배열 - https://school.programmers.co.kr/learn/courses/30/lessons/12910
public class Ex12910 {

    public static void main(String[] args) {
        System.out.println(Arrays.toString(solution(new int[]{5, 9, 7, 10}, 5))); // [5, 10]
        System.out.println(Arrays.toString(solution(new int[]{2, 36, 1, 3}, 1))); // [1, 2, 3, 36]
        System.out.println(Arrays.toString(solution(new int[]{3, 2, 6}, 10))); // [5, 10]
    }

    public static int[] solution(int[] arr, int divisor) {
        int[] answer = Arrays.stream(arr).filter(x -> x % divisor == 0).sorted().toArray();
        return answer.length == 0 ? new int[]{-1} : answer;
    }

}
