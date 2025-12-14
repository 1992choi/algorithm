package fastcampus.codingpackage.part3.ch04;

import java.util.Scanner;

/*
    풀이

    - 피보나치 수열은 동일한 부분 문제가 반복되므로 DP로 해결 가능하다.

    - fibo (Top-Down, 재귀 + 메모이제이션)
        * 이미 계산한 값은 memo 배열에 저장
        * 중복 호출을 제거하지만 재귀 호출 스택이 발생

    - fibo2 (Bottom-Up, 반복문)
        * 작은 값부터 차례대로 dp 배열을 채움
        * 재귀 없이 안정적으로 계산 가능

    - fibo3 (누적 방식의 Bottom-Up)
        * d[i]가 다음 두 칸(d[i+1], d[i+2])에 기여하는 방식
        * 점화식을 직접 계산하지 않고, 값의 흐름으로 누적
        * d 배열만으로 피보나치 계산 가능

    - n ≤ 90 이므로 long 타입 사용
*/
class Ex2748 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        System.out.println(fibo3(n));
    }

    // fibo (Top-Down, 재귀 + 메모이제이션)
    static long[] memo = new long[91];

    static long fibo(int n) {
        if (n == 1 || n == 2) return 1;
        if (memo[n] != 0) return memo[n];
        memo[n] = fibo(n - 1) + fibo(n - 2);
        return memo[n];
    }

    // fibo2 (Bottom-Up, 반복문)
    static long[] dp = new long[91];

    static long fibo2(int n) {
        dp[1] = dp[2] = 1;
        for (int i = 3; i <= n; i++) {
            dp[i] = dp[i - 1] + dp[i - 2];
        }
        return dp[n];
    }

    // fibo3 (누적 방식의 Bottom-Up)
    static long[] d = new long[93];

    static long fibo3(int n) {
        d[1] = 1;
        for (int i = 1; i <= n; i++) {
            d[i + 1] += d[i];
            d[i + 2] += d[i];
        }
        return dp[n];
    }


}