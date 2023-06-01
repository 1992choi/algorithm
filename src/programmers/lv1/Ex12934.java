package programmers.lv1;

// 프로그래머스 Lv1. 정수 제곱근 판별 - https://school.programmers.co.kr/learn/courses/30/lessons/12934
public class Ex12934 {

    public static void main(String[] args) {
        System.out.println(solution(121)); // 144
        System.out.println(solution(3)); // -1
    }

    public static long solution(int n) {
        long num = (long)Math.sqrt(n);
        if (num * num == n) {
            return (num + 1) * (num + 1);
        }

        return -1;
    }

}
