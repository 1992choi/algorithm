package programmers.lv1;

// 프로그래머스 Lv1. 이상한 문자 만들기 - https://school.programmers.co.kr/learn/courses/30/lessons/12930
public class Ex12930 {

    public static void main(String[] args) {
        System.out.println(solution("try hello world")); // TrY HeLlO WoRlD
    }

    public static String solution(String s) {
        String answer = "";

        int index = 0;
        for (int i = 0; i < s.length(); i++) {
            if (index % 2 == 0) {
                answer += Character.toUpperCase(s.charAt(i));
            } else {
                answer += Character.toLowerCase(s.charAt(i));
            }

            if (s.charAt(i) == ' ') {
                index = 0;
            } else {
                index++;
            }
        }

        return answer;
    }

}
