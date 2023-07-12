package inflearn.lecture02;

import java.util.Scanner;

public class Ex09_06_Answer {

    public static void main(String[] args) {
        /**
         5 1 3 1 5 2
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 벼의 수
        int[] nums = new int[n + 1]; // 벼의 가치
        for (int i = 1; i <= n; i++) {
            nums[i] = sc.nextInt();
        }

        int[][] dy = new int[n + 1][n + 1];
        int[] s = new int[n + 1];
        s[1] = nums[1];
        for (int i = 2; i <= n; i++) {
            s[i] = s[i - 1] + nums[i];
        }

        for (int i = 1; i <= n; i++) {
            dy[i][i] = nums[i];
        }

        for (int i = 1; i < n; i++) {
            for (int j = 1; j <= n - i; j++) {
                dy[j][j + i] = Math.max(dy[j + 1][j + i], dy[j][j + i - 1]) + s[j + i] - s[j - 1];
            }
        }

        System.out.println(dy[1][n]);
    }

}