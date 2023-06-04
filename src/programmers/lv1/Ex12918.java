package programmers.lv1;

// 프로그래머스 Lv1. 문자열 다루기 기본 - https://school.programmers.co.kr/learn/courses/30/lessons/12918
public class Ex12918 {

    public static void main(String[] args) {
        System.out.println(solution("a234")); // false
        System.out.println(solution("1234")); // true
    }

    public static boolean solution(String s) {
        if (!(s.length() == 4 || s.length() == 6)) {
            return false;
        }

        for (char c : s.toCharArray()) {
            if (!Character.isDigit(c)) {
                return false;
            }
        }

        return true;
    }

}
