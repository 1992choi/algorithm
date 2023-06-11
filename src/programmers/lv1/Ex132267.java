package programmers.lv1;

// 프로그래머스 Lv1. 콜라 문제 - https://school.programmers.co.kr/learn/courses/30/lessons/132267
public class Ex132267 {

    public static void main(String[] args) {
        System.out.println(solution(2, 1, 20)); // 19
        System.out.println(solution(3, 1, 20)); // 9
        System.out.println(solution(3, 2, 20)); // 36
    }

    public static int solution(int a, int b, int n) {
        int answer = 0;

        while (n >= 2) {
            // 받을 수 있는 콜라
            int addCnt = (n / a) * b;
            answer += (n / a) * b;
            if ((n / a) * b == 0) {
                break;
            }

            // 반납한 콜라
            int returnCnt =  (n / a) * b / b * a;

            // 콜라병 갱신
            n = n - returnCnt + ((n / a) * b);
        }

        return answer;
    }

}
