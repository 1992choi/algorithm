package inflearn.lecture01;

import java.util.Scanner;

public class Ex03_03_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        int targetDay = in.nextInt();
        int[] arr = new int[day];
        for (int i = 0; i < day; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(day, targetDay, arr));
    }

    public static int solution(int n, int k, int[] arr) {
        int answer = 0;
        int sum = 0;

        for (int i = 0; i < k; i++) {
            sum += arr[i];
        }
        answer = sum;

        for (int i = k; i < n; i++) {
            sum += arr[i] - arr[i - k];
            answer = Math.max(answer, sum);
        }

        return answer;
    }

}