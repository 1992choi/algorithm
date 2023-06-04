package programmers.lv1;

// 프로그래머스 Lv1. 약수의 개수와 덧셈 - https://school.programmers.co.kr/learn/courses/30/lessons/77884
public class Ex77884 {

    public static void main(String[] args) {
        System.out.println(solution(13, 17)); // 43
        System.out.println(solution(24, 27)); // 52
    }

    public static int solution(int left, int right) {
        int answer = 0;
        for (int i = left; i <= right; i++) {
            int divisorCount = 0;

            for (int j = 1; j <= i; j++) {
                if (i % j == 0) {
                    divisorCount++;
                }
            }

            answer += divisorCount % 2 == 0 ? i : -i;
        }

        return answer;
    }

}
