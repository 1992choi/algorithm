package programmers.lv1;

// 프로그래머스 Lv1. 자릿수 더하기 - https://school.programmers.co.kr/learn/courses/30/lessons/12931
public class Ex12931 {

    public static void main(String[] args) {
        System.out.println(solution(123)); // 6
        System.out.println(solution(987)); // 24
    }

    public static int solution(int n) {
        int answer = 0;
        for (char ch : String.valueOf(n).toCharArray()) {
            answer += ch - 48;
        }

        return answer;
    }

}
