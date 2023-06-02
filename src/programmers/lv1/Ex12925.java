package programmers.lv1;

// 프로그래머스 Lv1. 문자열을 정수로 바꾸기 - https://school.programmers.co.kr/learn/courses/30/lessons/12925
public class Ex12925 {

    public static void main(String[] args) {
        System.out.println(solution("1234")); // 1234
        System.out.println(solution("+1234")); // 1234
        System.out.println(solution("-1234")); // -1234
    }

    public static int solution(String s) {
        return Integer.parseInt(s);
    }

}
