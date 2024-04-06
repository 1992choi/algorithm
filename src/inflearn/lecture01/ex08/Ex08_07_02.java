package inflearn.lecture01.ex08;

import java.util.Scanner;

/**
 * 문제해법 보고 푼 문제.
 */
public class Ex08_07_02 {

    static int[][] memoization;
    static int n;
    static int r;

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        r = in.nextInt();
        memoization = new int[n + 1][r + 1];

        // 탐색 - 순열 구하기
        System.out.println(dfs(n, r));
    }

    public static int dfs(int n, int r) {
        if (memoization[n][r] != 0) {
            return memoization[n][r];
        }

        if (r == 0 || n == r) {
            return 1;
        } else {
            int left = memoization[n - 1][r - 1] = dfs(n - 1, r - 1);
            int right = memoization[n - 1][r] = dfs(n - 1, r);
            return left + right;
        }
    }
}