package programmers.lv2;

// 프로그래머스 Lv2. [3차] n진수 게임 - https://school.programmers.co.kr/learn/courses/30/lessons/17687
public class Ex17687 {

    public static void main(String[] args) {
        System.out.println(solution(2, 4, 2, 1)); // 0111
        System.out.println(solution(16, 16, 2, 1)); // 02468ACE11111111
        System.out.println(solution(16, 16, 2, 2)); // 13579BDF01234567
    }

    public static String solution(int n, int t, int m, int p) {
        StringBuilder answer = new StringBuilder();

        // 미리 n진수 만들기
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i <= t * m; i++) {
            sb.append(Integer.toString(i, n));
        }

        // 튜브가 말할 숫자 판단
        int startNum = p - 1; // 순서는 1부터, 인덱스는 0부터 시작하므로
        for (int i = startNum; i <= t * m; i+=m) {
            answer.append(sb.toString().charAt(i));

            if (answer.length() == t) {
                return answer.toString().toUpperCase();
            }
        }

        return null;
    }

}
