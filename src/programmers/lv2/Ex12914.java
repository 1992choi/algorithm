package programmers.lv2;

// 프로그래머스 Lv2. 멀리 뛰기 - https://school.programmers.co.kr/learn/courses/30/lessons/12914
public class Ex12914 {

    public static void main(String[] args) {
        System.out.println(solution2(4)); // 5
        System.out.println(solution2(3)); // 3
        System.out.println(solution2(1)); // 1
    }

    // 오답 - 특정 케이스부터 시간 초과 발생
    static long answer = 0;

    public static long solution(int n) {
        answer = 0;
        dfs(0, n);
        return answer % 1234567;
    }

    public static void dfs(int current, int n) {
        if (current > n) {
            return;
        }

        if (current == n) {
            answer++;
        } else {
            // 1칸 뛰기
            dfs(current + 1, n);

            // 2칸 뛰기
            dfs(current + 2, n);
        }
    }

    // 정답 - 풀이방법 참고한 로직
    public static long solution2(int n) {
        /*
            n의 경우의 수:
            n = 1일 때: 1가지 경우의 수 (1)
            n = 2일 때: 2가지 경우의 수 (1, 1), (2)
            n = 3일 때: 3가지 경우의 수 (1, 1, 1), (1, 2), (2, 1)
            n = 4일 때: 5가지 경우의 수 (1, 1, 1, 1), (1, 1, 2), (1, 2, 1), (2, 1, 1), (2, 2)
            n = 5일 때: 8가지 경우의 수 (1, 1, 1, 1, 1), (1, 1, 1, 2), (1, 1, 2, 1), (1, 2, 1, 1), (2, 1, 1, 1), (1, 2, 2), (2, 1, 2), (2, 2, 1)

            ==> n의 경우의 수는 (n-1)의 경우의 수 + (n-2)의 경우의 수 :  피보나치 수열 문제
         */
        long[] ans = new long[n + 2]; // n이 1인 경우를 위해 크기를 n+1이 아닌 n+2로 잡아줌.

        ans[0] = 0;
        ans[1] = 1;
        ans[2] = 2;

        for(int i = 3; i <= n; i++) {
            ans[i] = (ans[i - 1] + ans[i - 2]) % 1234567;
        }

        return ans[n];
    }

}