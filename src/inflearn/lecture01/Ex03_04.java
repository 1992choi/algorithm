package inflearn.lecture01;

import java.util.Scanner;

public class Ex03_04 {

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
        int p1 = 0;
        int p2 = 0;

        while (p2 < n) {
            int sum = 0;
            for (int i = p1; i <= p2; i++) {
                sum += arr[i];
                if (sum > m) {
                    break;
                }
            }

            if (sum == m) {
                answer++;
                p1++;
                p2++;
            } else if (sum > m) {
                p1++;
            } else {
                p2++;
            }
        }

        return answer;
    }

}