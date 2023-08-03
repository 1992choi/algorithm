package inflearn.lecture01.ex03;

import java.util.Scanner;

public class Ex03_06 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(n, k, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;

        for (int i = 0; i < n; i++) {
            int count = 0;
            int tmp = k;
            int p = i;
            while (p < n) {
                if (tmp == 0 && arr[p] == 0) {
                    break;
                } else {
                    count++;
                }

                if (arr[p] == 0) {
                    tmp--;
                }

                p++;
            }

            if (count > answer) {
                answer = count;
            }
        }

        return answer;
    }

}