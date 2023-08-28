package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_04_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int m = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, m, arr));
    }

    public static int solution(int n, int m, int[] arr) {
        int answer = 0;

        int lp = 0;
        int rp = 0;

        while (rp <= n) {
            int sum = 0;
            for (int i = lp; i < rp; i++) {
                sum += arr[i];
            }

            if (sum == m) {
                answer++;
                lp++;
                rp++;
            } else if (sum < m) {
                rp++;
            } else {
                lp++;
            }
        }

        return answer;
    }

}