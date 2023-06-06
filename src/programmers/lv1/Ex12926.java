package programmers.lv1;

// 프로그래머스 Lv1. 시저 암호 - https://school.programmers.co.kr/learn/courses/30/lessons/12926
public class Ex12926 {

    public static void main(String[] args) {
        System.out.println(solution("AB", 1)); // BC
        System.out.println(solution("z", 1)); // a
        System.out.println(solution("a B z", 4)); // e F d
    }

    public static String solution(String s, int n) {
        String answer = "";

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);
            if (s.charAt(i) == ' ') {
                answer += ' ';
            } else {
                if (Character.toLowerCase(s.charAt(i)) + n > 'z' &&
                        ('a' <= Character.toLowerCase(s.charAt(i)) && Character.toLowerCase(s.charAt(i)) <= 'z')) {
                    answer += (char) ((ch + n - 26));
                } else {
                    answer += (char) ((ch + n));
                }
            }
        }

        return answer;
    }

}