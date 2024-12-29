package goorm;

import java.util.Scanner;

// 연속 점수
public class Ex174924 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 풀이
        int maxScore = arr[n - 1]; // 요소 중 최대값. 요소의 마지막은 탐색하지 않으므로 마지막 값을 기본으로 셋팅
        int maxSum = 0; // 구간 합 중 최대값

        for (int i = 0; i < n - 1; i++) {
            int sum = arr[i]; // 구간 합
            for (int j = i + 1; j < n; j++) {
                // 연속되어 있는 경우를 판단하여 누적합 계산
                if (arr[j - 1] == arr[j] - 1) {
                    sum += arr[j];
                } else {
                    sum = 0;
                }

                maxSum = Math.max(maxSum, sum);
            }

            maxScore = Math.max(maxScore, arr[i]);
        }

        System.out.println(Math.max(maxScore, maxSum));
    }

}