package programmers.lv1;

// 프로그래머스 Lv1. 가운데 글자 가져오기 - https://school.programmers.co.kr/learn/courses/30/lessons/12903
public class Ex12903 {

    public static void main(String[] args) {
        System.out.println(solution("abcde")); // c
        System.out.println(solution("qwer")); // we
    }

    public static String solution(String s) {
        return s.length() % 2 == 0 ? (s.substring(s.length() / 2 - 1, s.length() / 2 + 1)) : (s.substring(s.length() / 2, s.length() / 2 + 1));
    }

}
