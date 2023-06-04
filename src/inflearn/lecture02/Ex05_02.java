package inflearn.lecture02;

import java.util.Arrays;

public class Ex05_02 {

    public static void main(String[] args) {
        System.out.println(solution(new int[]{2, 5, 3, 4, 2, 3})); // 4
        System.out.println(solution(new int[]{2, 3, 4, 5})); // 3
        System.out.println(solution(new int[]{3, 3, 3, 3, 3})); // 5
        System.out.println(solution(new int[]{1, 1, 3, 5})); // 2
        System.out.println(solution(new int[]{1, 1, 1, 2, 5})); // 2
    }

    public static int solution(int[] nums) {
        int answer = 0;
        int lt = 0;
        int rt = nums.length - 1;

        Arrays.sort(nums);

        while (lt <= rt) {
            if (nums[lt] + nums[rt] > 5) {
                rt--;
                answer++;
            } else {
                int sum = nums[lt] + nums[rt];
                lt++;
                rt--;
                while (sum <= 5) {
                    sum += nums[rt];
                    rt--;
                }

                answer++;
            }
        }

        return answer;
    }

}