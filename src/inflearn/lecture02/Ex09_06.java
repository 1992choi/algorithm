package inflearn.lecture02;

import java.util.Scanner;

public class Ex09_06 {

    public static void main(String[] args) {
        /*
            DP없이 풀어본 문제.
            테스트케이스는 맞았으나 실제 백준 사이트에서는 오답
         */
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(); // 벼의 수
        int[] arr = new int[n]; // 벼의 가치
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int answer = 0;
        int round = 1;
        int lp = 0;
        int rp = n - 1;

        while (lp <= rp) {
            if (arr[lp] > arr[rp]) {
                answer += arr[rp--] * round;
            } else {
                answer += arr[lp++] * round;
            }
            round++;
        }

        System.out.println(answer);
    }

}