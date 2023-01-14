package inflearn;

import java.util.Scanner;

public class Ex03_03 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int day = in.nextInt();
        int targetDay = in.nextInt();
        int[] arr = new int[day];
        for (int i = 0; i < day; i++) {
            arr[i] = in.nextInt();
        }

        System.out.println(solution(day, targetDay, arr));
        System.out.println(solution2(day, targetDay, arr));
    }

    public static int solution(int day, int targetDay, int[] arr) {
        int answer = 0;

        for (int i = 0; i < day - targetDay + 1; i++) {
            int sum = 0;
            for (int j = i; j < targetDay + i; j++) {
                sum += arr[j];
            }

            if (answer < sum) {
                answer = sum;
            }
        }

        return answer; // 시간초과 발생
    }

    public static int solution2(int day, int targetDay, int[] arr) {
        int[] sumArr = new int[day];

        int sum = 0;
        for (int i = 0; i < day; i++) {
            sum += arr[i];
            sumArr[i] = sum;
        }

        int answer = sumArr[targetDay - 1];
        for (int i = targetDay; i < day; i++) {
            if (answer < sumArr[i] - sumArr[i - targetDay]) {
                answer = sumArr[i] - sumArr[i - targetDay];
            }
        }

        return answer;
    }

}