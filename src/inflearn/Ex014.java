package inflearn;

import java.util.Scanner;

public class Ex014 {

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
        int min = 0;
        for (int i = 0; i < count; i++) {
            if (min < nums[i]) {
                answer ++;
                min = nums[i];
            }
        }

        return answer;
    }

}