package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_06_02 {

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
        for (int i = 0; i < count; i++) {
            // 자연수 뒤집기
            int reverseNum = Integer.parseInt(new StringBuffer(String.valueOf(nums[i])).reverse().toString());

            // 소수 판별 후 출력
            int divCount = 0;
            for (int j = 2; j <= reverseNum; j++) {
                if (reverseNum % j == 0) {
                    divCount++;
                }
            }
            if (divCount == 1) {
                System.out.print(reverseNum + " ");
            }
        }
    }

}