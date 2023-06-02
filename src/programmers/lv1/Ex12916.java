package programmers.lv1;

// 프로그래머스 Lv1. 문자열 내 p와 y의 개수 - https://school.programmers.co.kr/learn/courses/30/lessons/12916
public class Ex12916 {

    public static void main(String[] args) {
        System.out.println(solution("pPoooyY")); // true
        System.out.println(solution("Pyy")); // false
    }

    public static boolean solution(String s) {
        int pCnt = 0;
        int yCnt = 0;

        for (char ch : s.toLowerCase().toCharArray()) {
            if (ch == 'p') {
                pCnt++;
            } else if (ch == 'y') {
                yCnt++;
            }
        }

        return pCnt == yCnt;
    }

}
