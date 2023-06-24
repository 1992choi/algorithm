package programmers.lv1;

// 프로그래머스 Lv1. 소수 찾기 - https://school.programmers.co.kr/learn/courses/30/lessons/12921
public class Ex12921 {

    public static void main(String[] args) {
        System.out.println(solution(10)); // 4
        System.out.println(solution(5)); // 3
    }

    public static int solution(int n) {
        /** 에라토스테네스의 체 사용X */
//        int answer = 1; // 2는 소수이므로 카운트를 한 후 3부터 시작
//
//        for (int i = 3; i <= n; i++) {
//            if (i % 2 == 0) { // 짝수는 제외
//                continue;
//            }
//
//            boolean isPrime = true;
//            for (int j = 3; j < i; j++) {
//                if (i % j == 0) {
//                    isPrime = false;
//                    break;
//                }
//            }
//
//            if (isPrime) {
//                answer++;
//            }
//        }
//
//        return answer;

        /** 에라토스테네스의 체 사용O */
        int answer = 0;
        boolean[] prime = new boolean[n + 1];
        for (int i = 2; i <= n; i++) {
            prime[i] = true; // 2 ~ n번째 수를 true로 초기화
        }

        //제곱근 구하기
        int root = (int) Math.sqrt(n);
        for (int i = 2; i <= root; i++) { // 2 ~ 루트n까지 검사
            if (prime[i]) { // i번째의 수가 소수일 때
                for (int j = i; i * j <= n; j++) // 그 배수들을 다 false로 초기화(배수는 소수가 아니기 때문)
                    prime[i * j] = false;
            }
        }

        for (int i = 2; i <= n; i++) {
            if (prime[i])
                answer++;
        }

        return answer;
    }

}
