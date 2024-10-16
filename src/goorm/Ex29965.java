package goorm;

// 01 > 피자 쿠폰
public class Ex29965 {

    public static void main(String[] args) {
        System.out.println(solution("100 5")); // 124
        System.out.println(solution("10 3")); // 14
    }

    public static int solution(String str) {
        int n = Integer.parseInt(str.split(" ")[0]); // 지금 가지고 있는 쿠폰으로 시킬 수 있는 피자
        int m = Integer.parseInt(str.split(" ")[1]); // 피자 1판을 시킬 때 드는 쿠폰 수

        int answer = n;

        while (m <= n) {
            n = n - m + 1;
            answer++;
        }

        return answer;
    }

}
