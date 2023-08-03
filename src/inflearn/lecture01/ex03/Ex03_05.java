package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_05 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();

        System.out.println(solution(n));
    }

    public static int solution(int n) {
        int answer = 0;
        int lt = 0;
        int rt = 1;

        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = (i + 1);
        }

        while (rt < n) {
            int sum = 0;
            for (int i = lt; i < rt; i++) {
                sum += arr[i];

                if (sum > n) {
                    break;
                }
            }

            if (sum == n) {
                answer++;
                rt++;
                lt++;
            } else if (sum < n) {
                rt++;
            } else {
                lt++;
            }
        }

        return answer;
    }

}