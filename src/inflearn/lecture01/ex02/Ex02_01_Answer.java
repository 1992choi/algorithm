package inflearn.lecture01.ex02;

import java.util.Scanner;

public class Ex02_01_Answer {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(count, nums));
    }

    public static String solution(int count, int[] nums) {
        String answer = nums[0] + " ";
        for (int i = 1; i < count; i++) {
            if (nums[i - 1] < nums[i]) {
                answer += nums[i] + " ";
            }
        }

        return answer;
    }

}