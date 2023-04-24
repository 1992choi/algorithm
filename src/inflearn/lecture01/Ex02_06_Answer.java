package inflearn.lecture01;

import java.util.Scanner;

public class Ex02_06_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];

        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        solution(count, nums);
    }

    public static void solution(int count, int[] nums) {
        // 자연수 뒤집기
        for (int i = 0; i < count; i++) {
            int tmp = nums[i];
            int res = 0;
            while (tmp > 0) {
                int t = tmp % 10;
                res = res * 10 + t;
                tmp = tmp / 10;
            }

            if (isPrime(res)) {
                System.out.print(res + " ");
            }
        }
    }

    public static boolean isPrime(int num) {
        if (num == 1) {
            return false;
        }

        for (int i = 2; i < num; i++) {
            if (num % i == 0) {
                return false;
            }
        }

        return true;
    }

}