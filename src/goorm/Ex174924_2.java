package goorm;

import java.util.Arrays;
import java.util.Scanner;

// 연속 점수
public class Ex174924_2 {

    public static void main(String[] args) {
        // 입력값 셋팅
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // 풀이
        int[] sumArr = new int[n]; // 구간 합
        sumArr[0] = arr[0];

        int sum = arr[0];
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] == arr[i] - 1) {
                sum += arr[i];
            } else {
                sum = arr[i];
            }

            sumArr[i] = sum;
        }

        System.out.println(Arrays.stream(sumArr).max().getAsInt());
    }

}