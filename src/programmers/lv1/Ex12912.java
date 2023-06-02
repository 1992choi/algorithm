package programmers.lv1;

// 프로그래머스 Lv1. 두 정수 사이의 합 - https://school.programmers.co.kr/learn/courses/30/lessons/12912
public class Ex12912 {

    public static void main(String[] args) {
        System.out.println(solution(3, 5)); // 12
        System.out.println(solution(3, 3)); // 3
        System.out.println(solution(5, 3)); // 12
    }

    public static long solution(int a, int b) {
        long answer = 0;
        for (int i = Math.min(a, b); i <= Math.max(a, b); i++) {
            answer += i;
        }
        return answer;
    }

}
