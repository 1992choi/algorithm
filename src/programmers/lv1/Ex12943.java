package programmers.lv1;

// 프로그래머스 Lv1. 콜라츠 추측 - https://school.programmers.co.kr/learn/courses/30/lessons/12943
public class Ex12943 {

    public static void main(String[] args) {
        System.out.println(solution(6)); // 8
        System.out.println(solution(16)); // 4
        System.out.println(solution(626331)); // -1
    }

    public static int solution(long num) {
        int count = 0;

        while (num != 1) {
            if (num % 2 == 0) {
                num = num / 2;
            } else {
                num = num * 3 + 1;
            }

            count++;
            if (count == 500) {
                return -1;
            }
        }

        return count;
    }

}
