package programmers.lv1;

/*
    프로그래머스 Lv1. 짝수와 홀수
    - https://school.programmers.co.kr/learn/courses/30/lessons/12937
 */
public class Ex12937 {

    public static void main(String[] args) {
        System.out.println(solution(3)); // Odd
        System.out.println(solution(4)); // Even
    }

    public static String solution(int num) {
        return num % 2 == 0 ? "Even" : "Odd";
    }

}
