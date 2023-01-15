package inflearn;

import java.util.Scanner;

public class Ex03_05_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution1(n));
        System.out.println(solution2(n));
    }

    // two pointers 사용
    public static int solution1(int n) {
        int answer = 0;
        int sum = 0;
        int lt = 0;
        int m = n / 2 + 1;

        int[] arr = new int[m];
        for (int i = 0; i < m; i++) {
            arr[i] = (i + 1);
        }

        for (int rt = 0; rt < m; rt++) {
            sum += arr[rt];
            if (sum == n) {
                answer++;
            }

            while (sum >= n) {
                sum -= arr[lt];
                lt++;
                if (sum == n) {
                    answer++;
                }
            }

        }

        return answer;
    }

    // 수학적 접근
    public static int solution2(int n) {
        int answer = 0;
        int cnt = 1;
        n--;
        while (n > 0) {
            cnt++;
            n = n - cnt;

            if (n % cnt == 0) {
                answer++;
            }
        }

        return answer;
    }

}