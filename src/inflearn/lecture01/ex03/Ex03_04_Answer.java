package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_04_Answer {

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
        int sum = 0;
        int lt = 0;

        for (int rt = 0; rt < n; rt++) {
            sum += arr[rt];
            if (sum == m) {
                answer++;
            }

            while(sum >= m) {
                sum -= arr[lt];
                lt++;
                if (sum == m) {
                    answer++;
                }
            }
        }

        return answer;
    }

}