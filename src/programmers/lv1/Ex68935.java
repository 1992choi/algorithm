package programmers.lv1;

// 프로그래머스 Lv1. 3진법 뒤집기 - https://school.programmers.co.kr/learn/courses/30/lessons/68935
public class Ex68935 {

    public static void main(String[] args) {
        System.out.println(solution(45)); // 7
        System.out.println(solution(125)); // 229
    }

    public static int solution(int n) {
        return Integer.parseInt(new StringBuilder(Integer.toString(n, 3)).reverse().toString(), 3);
    }

}
