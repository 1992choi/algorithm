package inflearn;

import java.util.Scanner;

public class Ex02_02 {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count = in.nextInt();
        int[] nums = new int[count];
        for (int i = 0; i < count; i++) {
            nums[i] = in.nextInt();
        }

        System.out.println(solution(count, nums));
    }

    public static int solution(int count, int[] nums) {
        int answer = 0;
        int max = 0;
        for (int i = 0; i < count; i++) {
            if (max < nums[i]) {
                answer ++;
                max = nums[i];
            }
        }

        return answer;
    }

}