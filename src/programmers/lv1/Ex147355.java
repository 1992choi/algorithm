package programmers.lv1;

// 프로그래머스 Lv1. 크기가 작은 부분 문자열 - https://school.programmers.co.kr/learn/courses/30/lessons/147355
public class Ex147355 {

    public static void main(String[] args) {
        System.out.println(solution("3141592", "271")); // 2
        System.out.println(solution("500220839878", "7")); // 8
        System.out.println(solution("10203", "15")); // 3
    }

    public static int solution(String t, String p) {
        int answer = 0;
        for (int i = 0; i < t.length() - p.length() + 1; i++) {
            if (Long.parseLong(t.substring(i, i + p.length())) <= Long.parseLong(p)) {
                answer++;
            }
        }
        return answer;
    }

}
