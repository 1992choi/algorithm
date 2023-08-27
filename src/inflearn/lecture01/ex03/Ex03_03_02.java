package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_03_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
        System.out.println(solution2(n, k, arr));
    }

    // Time Limit Exceeded
    public static int solution(int n, int k, int[] arr) {
        int max = Integer.MIN_VALUE;

        for (int i = 0; i < n - k; i++) {
            int sum = 0;
            for (int j = i; j < i + k; j++) {
                sum += arr[j];
            }

            max = Math.max(max, sum);
        }

        return max;
    }

    public static int solution2(int n, int k, int[] arr) {
        int[] sumArr = new int[n + 1]; // 구간합
        for (int i = 1; i < n + 1; i++) {
            sumArr[i] = sumArr[i - 1] + arr[i - 1];
        }

        int max = Integer.MIN_VALUE;
        for (int i = k; i < n + 1; i++) {
            max = Math.max(max, sumArr[i] - sumArr[i - k]);
        }

        return max;
    }

}