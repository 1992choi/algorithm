package programmers.lv1;

/*
    프로그래머스 Lv1. 나머지가 1이 되는 수 찾기
    - https://school.programmers.co.kr/learn/courses/30/lessons/87389
 */
public class Ex87389 {

    public static void main(String[] args) {
        System.out.println(solution(10)); // 3
        System.out.println(solution(12)); // 11
    }

    public static int solution(int n) {
        for (int i = 1; i < n; i++) {
            if (n % i == 1) {
                return i;
            }
        }

        return n;
    }

}
